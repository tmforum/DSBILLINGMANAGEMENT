package org.tmf.dsmapi.billingAccount;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.jaxrs.Report;
import org.tmf.dsmapi.billingAccount.model.BillingAccount;
import org.tmf.dsmapi.billingAccount.event.BillingAccountEvent;
import org.tmf.dsmapi.billingAccount.event.BillingAccountEventFacade;
import org.tmf.dsmapi.billingAccount.event.BillingAccountEventPublisherLocal;
import org.tmf.dsmapi.billingAccount.model.BillingAccountBalance;
import org.tmf.dsmapi.billingAccount.model.BillingAccountState;
import org.tmf.dsmapi.billingAccount.model.Currency;
import org.tmf.dsmapi.billingAccount.model.CustomerAccount;
import org.tmf.dsmapi.billingAccount.model.CustomerBillFormat;
import org.tmf.dsmapi.billingAccount.model.CustomerBillPresentationMedia;
import org.tmf.dsmapi.billingAccount.model.CustomerBillingCycleSpecification;
import org.tmf.dsmapi.billingAccount.model.PaymentMean;
import org.tmf.dsmapi.billingAccount.model.RelatedParty;
import org.tmf.dsmapi.billingAccount.model.TimePeriod;

@Stateless
@Path("admin/billingAccount")
public class BillingAccountAdminResource {

    @EJB
    BillingAccountFacade billingAccountFacade;
    @EJB
    BillingAccountEventFacade eventFacade;
    @EJB
    BillingAccountEventPublisherLocal publisher;

    @GET
    @Produces({"application/json"})
    public List<BillingAccount> findAll() {
        return billingAccountFacade.findAll();
    }

    /**
     *
     * For test purpose only
     *
     * @param entities
     * @return
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response post(List<BillingAccount> entities) {

        if (entities == null) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }

        int previousRows = billingAccountFacade.count();
        int affectedRows;

        // Try to persist entities
        try {
            affectedRows = billingAccountFacade.create(entities);
        } catch (BadUsageException e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }

        Report stat = new Report(billingAccountFacade.count());
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        // 201 OK
        return Response.created(null).
                entity(stat).
                build();
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response update(@PathParam("id") long id, BillingAccount entity) throws UnknownResourceException {
        Response response = null;
        BillingAccount billingAccount = billingAccountFacade.find(id);
        if (billingAccount != null) {
            entity.setId(id);
            billingAccountFacade.edit(entity);
            // 201 OK + location
            response = Response.status(Response.Status.CREATED).entity(entity).build();

        } else {
            // 404 not found
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }

    /**
     *
     * For test purpose only
     *
     * @return
     * @throws org.tmf.dsmapi.commons.exceptions.UnknownResourceException
     */
    @DELETE
    public Report deleteAll() throws UnknownResourceException {

        eventFacade.removeAll();
        int previousRows = billingAccountFacade.count();
        billingAccountFacade.removeAll();
        List<BillingAccount> pis = billingAccountFacade.findAll();
        for (BillingAccount pi : pis) {
            delete(pi.getId());
        }

        int currentRows = billingAccountFacade.count();
        int affectedRows = previousRows - currentRows;

        Report stat = new Report(currentRows);
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        return stat;
    }

    /**
     *
     * For test purpose only
     *
     * @param id
     * @return
     * @throws UnknownResourceException
     */
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws UnknownResourceException {
        int previousRows = billingAccountFacade.count();
        BillingAccount entity = billingAccountFacade.find(id);

        try {
            //Pause for 4 seconds to finish notification
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BillingAccountAdminResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        // remove event(s) binding to the resource
        List<BillingAccountEvent> events = eventFacade.findAll();
        for (BillingAccountEvent event : events) {
            if (event.getResource().getId().equals(id)) {
                eventFacade.remove(event.getId());
            }
        }
        //remove resource
        billingAccountFacade.remove(id);

        int affectedRows = 1;
        Report stat = new Report(billingAccountFacade.count());
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        // 200 
        Response response = Response.ok(stat).build();
        return response;
    }

    @GET
    @Produces({"application/json"})
    @Path("event")
    public List<BillingAccountEvent> findAllEvents() {
        return eventFacade.findAll();
    }

    @DELETE
    @Path("event")
    public Report deleteAllEvent() {

        int previousRows = eventFacade.count();
        eventFacade.removeAll();
        int currentRows = eventFacade.count();
        int affectedRows = previousRows - currentRows;

        Report stat = new Report(currentRows);
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        return stat;
    }

    @DELETE
    @Path("event/{id}")
    public Response deleteEvent(@PathParam("id") String id) throws UnknownResourceException {

        int previousRows = eventFacade.count();
        List<BillingAccountEvent> events = eventFacade.findAll();
        for (BillingAccountEvent event : events) {
            if (event.getResource().getId().equals(id)) {
                eventFacade.remove(event.getId());

            }
        }
        int currentRows = eventFacade.count();
        int affectedRows = previousRows - currentRows;

        Report stat = new Report(currentRows);
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        // 200 
        Response response = Response.ok(stat).build();
        return response;
    }

    /**
     *
     * @return
     */
    @GET
    @Path("count")
    @Produces({"application/json"})
    public Report count() {
        return new Report(billingAccountFacade.count());
    }

    @GET
    @Produces({"application/json"})
    @Path("proto")
    public BillingAccount proto() {
        BillingAccount billingAccount = new BillingAccount();
        billingAccount.setId(new Long(1));
        billingAccount.setHref("http://serverLocalisation:port/DSBillingManagement/api/billingManagement/v2/billingAccount/1");
        billingAccount.setRatingType("postpaid");
        billingAccount.setName("my personal Billing Account");
        billingAccount.setState(BillingAccountState.Active);
        TimePeriod timePeriod = new TimePeriod();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(2014, 05, 15);
        timePeriod.setStartPeriod(gc.getTime());
        billingAccount.setValidFor(timePeriod);
        
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setId("15");
        customerAccount.setHref("http://serverlocation:port/customerManagement/customerAccount/15");
        customerAccount.setName("Customer Account xxx");
        billingAccount.setCustomerAccount(customerAccount);
        
        CustomerBillingCycleSpecification cbCycleSpecif = new CustomerBillingCycleSpecification();
        cbCycleSpecif.setHref("http://server:port/billingManagement/customerbillingCycleSpecification/26");
        cbCycleSpecif.setFrequency("monthly");
        cbCycleSpecif.setBillingDateShift(new Integer(15));
        cbCycleSpecif.setName("Monthly billing on the 15");
        billingAccount.setCustomerBillingCycleSpecification(cbCycleSpecif);
        
        CustomerBillFormat customerBillFormat = new CustomerBillFormat();
        customerBillFormat.setId(new Long(23));
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
        
        List<RelatedParty> relatedParties = new ArrayList<RelatedParty>();
        RelatedParty relatedParty = new RelatedParty();
        relatedParty.setId("1");
        relatedParty.setHref("http://serverlocation:port/partyManagement/partyRole/1");
        relatedParty.setRole("bill receiver");
        relatedParties.add(relatedParty);
        
        relatedParty = new RelatedParty();
        relatedParty.setId("5");
        relatedParty.setHref("http://serverlocation:port/partyManagement/partyRole/5");
        relatedParty.setRole("bill responsible");
        relatedParties.add(relatedParty);
        
        billingAccount.setRelatedParty(relatedParties);
        
        PaymentMean paymentMean = new PaymentMean();
        paymentMean.setId("45");
        paymentMean.setHref("http://serverlocation:port/customerManagement/paymentMean/45");
        paymentMean.setName("my favourite payment mean");
        billingAccount.setPaymentMean(paymentMean);
    
        return billingAccount;
    }

}
