package org.tmf.dsmapi.customerBillFormat;

import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.CustomerBillFormat;
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

    @Override
    public void create(CustomerBillFormat entity) throws BadUsageException {
        if (entity.getId() != null) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC, "While creating CustomerBillFormat, id must be null");
        }

        super.create(entity);
    }

}
