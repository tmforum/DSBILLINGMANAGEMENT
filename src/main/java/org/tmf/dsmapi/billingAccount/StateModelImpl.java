package org.tmf.dsmapi.billingAccount;


import org.tmf.dsmapi.billingAccount.model.BillingAccountState;
import org.tmf.dsmapi.commons.workflow.StateModelBase;

/**
 *
 * @author maig7313
 */
public class StateModelImpl extends StateModelBase<BillingAccountState> {
    
    /**
     *
     */
    public StateModelImpl() {
        super(BillingAccountState.class);
    }    

    /**
     *
     */
    @Override
    protected void draw() {
        // First
        from(BillingAccountState.DEFINED).to(
                BillingAccountState.ACTIVE);

        // Somewhere
        from(BillingAccountState.ACTIVE).to(
                BillingAccountState.SUSPENDED,
                BillingAccountState.PENDING_CLOSED,
                BillingAccountState.PENDING_UPDATE);       
        from(BillingAccountState.SUSPENDED).to(
                BillingAccountState.CLOSED,
                BillingAccountState.ACTIVE);
        from(BillingAccountState.PENDING_UPDATE).to(
                BillingAccountState.ACTIVE);
        from(BillingAccountState.PENDING_CLOSED).to(
                BillingAccountState.CLOSED);

        // Final
        from(BillingAccountState.CLOSED);
//        from(State.REJECTED);
    }
}
