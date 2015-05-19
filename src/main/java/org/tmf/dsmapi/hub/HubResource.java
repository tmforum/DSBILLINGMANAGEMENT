package org.tmf.dsmapi.hub;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.tmf.dsmapi.billingAccount.event.BillingAccountEvent;
import org.tmf.dsmapi.billingAccount.event.BillingAccountEventTypeEnum;
import org.tmf.dsmapi.billingAccount.model.BillingAccount;
import org.tmf.dsmapi.billingAccount.model.BillingAccountBalance;
import org.tmf.dsmapi.billingAccount.model.BillingAccountState;
import org.tmf.dsmapi.billingAccount.model.BillingReference;
import org.tmf.dsmapi.billingAccount.model.Currency;
import org.tmf.dsmapi.billingAccount.model.CustomerAccount;
import org.tmf.dsmapi.billingAccount.model.CustomerBillFormat;
import org.tmf.dsmapi.billingAccount.model.CustomerBillPresentationMedia;
import org.tmf.dsmapi.billingAccount.model.CustomerBillingCycleSpecification;
import org.tmf.dsmapi.billingAccount.model.PaymentMean;
import org.tmf.dsmapi.billingAccount.model.RelatedParty;
import org.tmf.dsmapi.billingAccount.model.TimePeriod;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.jaxrs.Report;

@Stateless
@Path("/billingManagement/v2/hub")
public class HubResource {

    @EJB
    HubFacade hubFacade;

    public HubResource() {
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(Hub entity) throws BadUsageException {
        entity.setId(null);
        hubFacade.create(entity);
        //201
        return Response.status(Response.Status.CREATED).entity(entity).build();
    }

    @DELETE
    public Report deleteAllHub() {

        int previousRows = hubFacade.count();
        hubFacade.removeAll();
        int currentRows = hubFacade.count();
        int affectedRows = previousRows - currentRows;

        Report stat = new Report(currentRows);
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        return stat;
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") String id) throws UnknownResourceException {
        Hub hub = hubFacade.find(id);
        if (null == hub) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            hubFacade.remove(id);
            // 204
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @GET
    @Produces({"application/json"})
    public List<Hub> findAll() {
        return hubFacade.findAll();
    }

    @GET
    @Produces({"application/json"})
    @Path("proto/billingAccount/event")
    public BillingAccountEvent protobillingaccountevent() {
        BillingAccountEvent event = new BillingAccountEvent();
        BillingAccountEventTypeEnum x = BillingAccountEventTypeEnum.BillingAccountStateChangedNotification;
        event.setEventType(x);
        event.setEventTime(new Date());
        event.setId("18");

        GregorianCalendar gc = new GregorianCalendar();
        TimePeriod timePeriod = null;

        BillingAccount billingAccount = new BillingAccount();
        billingAccount.setId(new Long(1));
        billingAccount.setHref("http://serverLocalisation:port/DSBillingManagement/api/billingManagement/v2/billingAccount/1");
        billingAccount.setRatingType("postpaid");
        billingAccount.setName("my personal Billing Account");
        billingAccount.setState(BillingAccountState.Active);
        timePeriod = new TimePeriod();
        gc.set(2014, 05, 15);
        timePeriod.setStartPeriod(gc.getTime());
        billingAccount.setValidFor(timePeriod);
        
        BillingReference customerAccount = new BillingReference();
        customerAccount.setId("15");
        customerAccount.setHref("http://serverlocation:port/customerManagement/customerAccount/15");
        customerAccount.setName("Customer Account xxx");
        billingAccount.setCustomerAccount(customerAccount);
        
        BillingReference cbCycleSpecif = new BillingReference();
        cbCycleSpecif.setHref("http://server:port/billingManagement/customerbillingCycleSpecification/26");
//        cbCycleSpecif.setFrequency("monthly");
//        cbCycleSpecif.setBillingDateShift(new Integer(15));
        cbCycleSpecif.setName("Monthly billing on the 15");
        billingAccount.setCustomerBillingCycleSpecification(cbCycleSpecif);
        
        BillingReference customerBillFormat = new BillingReference();
        customerBillFormat.setId("23");
        customerBillFormat.setHref("http://serverlocation:port/billingManagement/customerBillFormat/23");
        customerBillFormat.setName("Detailed invoice");
        billingAccount.setCustomerBillFormat(customerBillFormat);
        
        CustomerBillPresentationMedia cbPresentationMedia = new CustomerBillPresentationMedia();
        cbPresentationMedia.setId(new Long(25));
        cbPresentationMedia.setHref("http://serverlocation:port/billingManagement/customerBillPresentationMedia/25");
        cbPresentationMedia.setName("Electronic invoice");
        
        Currency currency = new Currency();
        currency.setCurrencyCode("EUR");
        billingAccount.setCurrency(currency);
        
        List<BillingAccountBalance> billingAccountBalances = new ArrayList<BillingAccountBalance>();
        BillingAccountBalance baBalance = new BillingAccountBalance();
        baBalance.setType("ReceivableBalance");
        baBalance.setAmount(new Float("52.3"));
        baBalance.setStatus("Due");
        timePeriod = new TimePeriod();
        gc.set(2014, 05, 15);
        timePeriod.setStartPeriod(gc.getTime());
        gc.set(2099, 01, 01);
        timePeriod.setEndPeriod(gc.getTime());
        baBalance.setValidFor(timePeriod);
        billingAccountBalances.add(baBalance);
        billingAccount.setBillingAccountBalance(billingAccountBalances);
        
        List<BillingReference> relatedParties = new ArrayList<BillingReference>();
        BillingReference relatedParty = new BillingReference();
        relatedParty.setId("1");
        relatedParty.setHref("http://serverlocation:port/partyManagement/partyRole/1");
        relatedParty.setRole("bill receiver");
        relatedParties.add(relatedParty);
        
        relatedParty = new BillingReference();
        relatedParty.setId("5");
        relatedParty.setHref("http://serverlocation:port/partyManagement/partyRole/5");
        relatedParty.setRole("bill responsible");
        relatedParties.add(relatedParty);
        
        billingAccount.setRelatedParty(relatedParties);
        
        BillingReference paymentMean = new BillingReference();
        paymentMean.setId("45");
        paymentMean.setHref("http://serverlocation:port/customerManagement/paymentMean/45");
        paymentMean.setName("my favourite payment mean");
        billingAccount.setPaymentMean(paymentMean);
        
        event.setResource(billingAccount);
        
        return event;
    }
}
