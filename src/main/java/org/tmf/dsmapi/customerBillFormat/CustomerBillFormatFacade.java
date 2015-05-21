package org.tmf.dsmapi.customerBillFormat;

import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.CustomerBillFormat;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.customerBillFormat.event.CustomerBillFormatEventPublisherLocal;

@Stateless
public class CustomerBillFormatFacade extends AbstractFacade<CustomerBillFormat> {

    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
    @EJB
    CustomerBillFormatEventPublisherLocal publisher;

    public CustomerBillFormatFacade() {
        super(CustomerBillFormat.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void checkCreation(CustomerBillFormat newCustomerBillFormat) throws BadUsageException, UnknownResourceException {
        if (newCustomerBillFormat.getId() != null) {
            if (this.find(newCustomerBillFormat.getId()) != null) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                        "Duplicate Exception, CustomerBillFormat with same id :" + newCustomerBillFormat.getId() + " alreay exists");
            }
        }
    }

}
