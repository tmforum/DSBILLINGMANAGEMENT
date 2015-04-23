package org.tmf.dsmapi.subscriber;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import org.tmf.dsmapi.subscriber.EventBag;

/**
 *
 * @author ecus6396
 */
@Stateless
public class SubscriberFacade extends AbstractFacade<EventBag> {

    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;

    public SubscriberFacade() {
        super(EventBag.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
