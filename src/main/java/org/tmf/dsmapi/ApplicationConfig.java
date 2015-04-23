package org.tmf.dsmapi;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {
    
    public ApplicationConfig() {
        packages ("org.codehaus.jackson.jaxrs");
        
        
         register(org.tmf.dsmapi.commons.jaxrs.BadUsageExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.JacksonConfigurator.class);
        register(org.tmf.dsmapi.commons.jaxrs.JsonMappingExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.UnknowResourceExceptionMapper.class);
        register(org.tmf.dsmapi.hub.HubResource.class);
        register(org.tmf.dsmapi.billingAccount.BillingAccountResource.class);
        register(org.tmf.dsmapi.billingAccount.BillingAccountAdminResource.class);
        register(org.tmf.dsmapi.customerBillingCycleSpecification.CustomerBillingCycleSpecificationResource.class);
        register(org.tmf.dsmapi.customerBillingCycleSpecification.CustomerBillingCycleSpecificationAdminResource.class);
        register(org.tmf.dsmapi.appliedCustomerBillingCharge.AppliedCustomerBillingChargeResource.class);
        register(org.tmf.dsmapi.appliedCustomerBillingCharge.AppliedCustomerBillingChargeAdminResource.class);
        register(org.tmf.dsmapi.settlementNoteAdvice.SettlementNoteAdviceResource.class);
        register(org.tmf.dsmapi.settlementNoteAdvice.SettlementNoteAdviceAdminResource.class);
        register(org.tmf.dsmapi.customerBillFormat.CustomerBillFormatResource.class);
        register(org.tmf.dsmapi.customerBillFormat.CustomerBillFormatAdminResource.class);
        register(org.tmf.dsmapi.customerBillPresentationMedia.CustomerBillPresentationMediaResource.class);
        register(org.tmf.dsmapi.customerBillPresentationMedia.CustomerBillPresentationMediaAdminResource.class);
    }

   
    
}

