package org.tmf.dsmapi.customerBillPresentationMedia;

import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.CustomerBillPresentationMedia;
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

    @Override
    public void create(CustomerBillPresentationMedia entity) throws BadUsageException {
        if (entity.getId() != null) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC, "While creating CustomerBillPresentationMedia, id must be null");
        }

        super.create(entity);
    }

}
