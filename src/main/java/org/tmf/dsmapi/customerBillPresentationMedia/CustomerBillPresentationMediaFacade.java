package org.tmf.dsmapi.customerBillPresentationMedia;

import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.CustomerBillPresentationMedia;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.customerBillPresentationMedia.event.CustomerBillPresentationMediaEventPublisherLocal;

@Stateless
public class CustomerBillPresentationMediaFacade extends AbstractFacade<CustomerBillPresentationMedia> {

    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
    @EJB
    CustomerBillPresentationMediaEventPublisherLocal publisher;

    public CustomerBillPresentationMediaFacade() {
        super(CustomerBillPresentationMedia.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void checkCreation(CustomerBillPresentationMedia newCustomerBillPresentationMedia) throws BadUsageException, UnknownResourceException {
        if (newCustomerBillPresentationMedia.getId() != null) {
            if (this.find(newCustomerBillPresentationMedia.getId()) != null) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                        "Duplicate Exception, CustomerBillPresentationMedia with same id :" + newCustomerBillPresentationMedia.getId() + " alreay exists");
            }
        }
    }

}
