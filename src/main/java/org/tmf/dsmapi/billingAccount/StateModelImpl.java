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
        from(BillingAccountState.Defined).to(
                BillingAccountState.Active);

        // Somewhere
        from(BillingAccountState.Active).to(
                BillingAccountState.Suspended,
                BillingAccountState.Pending_Closed,
                BillingAccountState.Pending_Update);       
        from(BillingAccountState.Suspended).to(
                BillingAccountState.Closed,
                BillingAccountState.Active);
        from(BillingAccountState.Pending_Update).to(
                BillingAccountState.Active);
        from(BillingAccountState.Pending_Closed).to(
                BillingAccountState.Closed);

        // Final
        from(BillingAccountState.Closed);
//        from(State.REJECTED);
    }
}
