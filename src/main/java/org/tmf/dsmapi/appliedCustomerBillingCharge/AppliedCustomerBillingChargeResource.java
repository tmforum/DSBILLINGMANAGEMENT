package org.tmf.dsmapi.appliedCustomerBillingCharge;

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
import javax.ws.rs.POST;
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
import org.tmf.dsmapi.billingAccount.model.AppliedCustomerBillingCharge;
import org.tmf.dsmapi.appliedCustomerBillingCharge.AppliedCustomerBillingChargeFacade;
import org.tmf.dsmapi.appliedCustomerBillingCharge.event.AppliedCustomerBillingChargeEventPublisherLocal;
import org.tmf.dsmapi.commons.jaxrs.PATCH;

@Stateless
@Path("/billingManagement/v2/appliedCustomerBillingCharge")
public class AppliedCustomerBillingChargeResource {

    @EJB
    AppliedCustomerBillingChargeFacade appliedCustomerBillingChargeFacade;
    @EJB
    AppliedCustomerBillingChargeEventPublisherLocal publisher;

    public AppliedCustomerBillingChargeResource() {
    }

    /**
     * Test purpose only
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(AppliedCustomerBillingCharge entity, @Context UriInfo info) throws BadUsageException, UnknownResourceException {
        appliedCustomerBillingChargeFacade.checkCreation(entity);
        appliedCustomerBillingChargeFacade.create(entity);
        entity.setHref(info.getAbsolutePath()+ "/" + Long.toString(entity.getId()));
        appliedCustomerBillingChargeFacade.edit(entity);
        publisher.createNotification(entity, new Date());
        // 201
        Response response = Response.status(Response.Status.CREATED).entity(entity).build();
        return response;
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

        Set<AppliedCustomerBillingCharge> resultList = findByCriteria(mutableMap);

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
    private Set<AppliedCustomerBillingCharge> findByCriteria(Map<String, List<String>> criteria) throws BadUsageException {

        List<AppliedCustomerBillingCharge> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = appliedCustomerBillingChargeFacade.findByCriteria(criteria, AppliedCustomerBillingCharge.class);
        } else {
            resultList = appliedCustomerBillingChargeFacade.findAll();
        }
        if (resultList == null) {
            return new LinkedHashSet<AppliedCustomerBillingCharge>();
        } else {
            return new LinkedHashSet<AppliedCustomerBillingCharge>(resultList);
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

        AppliedCustomerBillingCharge appliedCustomerBillingCharge = appliedCustomerBillingChargeFacade.find(id);
        Response response;

        // If the result list (list of bills) is not empty, it conains only 1 unique bill
        if (appliedCustomerBillingCharge != null) {
            // 200
            if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
                response = Response.ok(appliedCustomerBillingCharge).build();
            } else {
                fieldSet.add(URIParser.ID_FIELD);
                ObjectNode node = Jackson.createNode(appliedCustomerBillingCharge, fieldSet);
                response = Response.ok(node).build();
            }
        } else {
            // 404 not found
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }

//    @PATCH
//    @Path("{id}")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    public Response patch(@PathParam("id") long id, AppliedCustomerBillingCharge partialCBC) throws BadUsageException, UnknownResourceException {
//        Response response = null;
//        AppliedCustomerBillingCharge currentCBC = appliedCustomerBillingChargeFacade.updateAttributs(id, partialCBC);
//
//        // 201 OK + location
//        response = Response.status(Response.Status.CREATED).entity(currentCBC).build();
//
//        return response;
//    }
}
