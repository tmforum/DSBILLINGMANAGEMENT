package org.tmf.dsmapi.customerBillingCycleSpecification;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.node.ObjectNode;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.utils.Jackson;
import org.tmf.dsmapi.commons.utils.URIParser;
import org.tmf.dsmapi.billingAccount.model.CustomerBillingCycleSpecification;
import org.tmf.dsmapi.customerBillingCycleSpecification.CustomerBillingCycleSpecificationFacade;
import org.tmf.dsmapi.customerBillingCycleSpecification.event.CustomerBillingCycleSpecificationEventPublisherLocal;

@Stateless
@Path("/billingManagement/v2/customerBillingCycleSpecification")
public class CustomerBillingCycleSpecificationResource {

    @EJB
    CustomerBillingCycleSpecificationFacade customerBillingCycleSpecificationFacade;
    @EJB
    CustomerBillingCycleSpecificationEventPublisherLocal publisher;

    public CustomerBillingCycleSpecificationResource() {
    }


    @GET
    @Produces({"application/json"})
    public Response find(@Context UriInfo info) throws BadUsageException {

        // search queryParameters
        MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

        Map<String, List<String>> mutableMap = new HashMap();
        for (Map.Entry<String, List<String>> e : queryParameters.entrySet()) {
            mutableMap.put(e.getKey(), e.getValue());
        }

        // fields to filter view
        Set<String> fieldSet = URIParser.getFieldsSelection(mutableMap);

        Set<CustomerBillingCycleSpecification> resultList = findByCriteria(mutableMap);

        Response response;
        if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
            response = Response.ok(resultList).build();
        } else {
            fieldSet.add(URIParser.ID_FIELD);
            List<ObjectNode> nodeList = Jackson.createNodes(resultList, fieldSet);
            response = Response.ok(nodeList).build();
        }
        return response;
    }

    // return Set of unique elements to avoid List with same elements in case of join
    private Set<CustomerBillingCycleSpecification> findByCriteria(Map<String, List<String>> criteria) throws BadUsageException {

        List<CustomerBillingCycleSpecification> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = customerBillingCycleSpecificationFacade.findByCriteria(criteria, CustomerBillingCycleSpecification.class);
        } else {
            resultList = customerBillingCycleSpecificationFacade.findAll();
        }
        if (resultList == null) {
            return new LinkedHashSet<CustomerBillingCycleSpecification>();
        } else {
            return new LinkedHashSet<CustomerBillingCycleSpecification>(resultList);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response get(@PathParam("id") long id, @Context UriInfo info) throws UnknownResourceException {

        // search queryParameters
        MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

        Map<String, List<String>> mutableMap = new HashMap();
        for (Map.Entry<String, List<String>> e : queryParameters.entrySet()) {
            mutableMap.put(e.getKey(), e.getValue());
        }

        // fields to filter view
        Set<String> fieldSet = URIParser.getFieldsSelection(mutableMap);

        CustomerBillingCycleSpecification customerBillingCycleSpecification = customerBillingCycleSpecificationFacade.find(id);
        Response response;
       
        // If the result list (list of bills) is not empty, it conains only 1 unique bill
        if (customerBillingCycleSpecification != null) {
            // 200
            if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
                response = Response.ok(customerBillingCycleSpecification).build();
            } else {
                fieldSet.add(URIParser.ID_FIELD);
                ObjectNode node = Jackson.createNode(customerBillingCycleSpecification, fieldSet);
                response = Response.ok(node).build();
            }
        } else {
            // 404 not found
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }




}
