package org.tmf.dsmapi.billingAccount;

import java.util.HashMap;
import java.util.Map;
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
import org.tmf.dsmapi.billingAccount.model.BillingAccount;
import org.tmf.dsmapi.billingAccount.event.BillingAccountEventPublisherLocal;
import org.tmf.dsmapi.commons.jaxrs.PATCH;

@Stateless
@Path("/billingManagement/v2/billingAccount")
public class BillingAccountResource {

    @EJB
    BillingAccountFacade billingAccountFacade;
    @EJB
    BillingAccountEventPublisherLocal publisher;

    public BillingAccountResource() {
    }

    /**
     * Test purpose only
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create(BillingAccount entity, @Context UriInfo info) throws BadUsageException, UnknownResourceException {
        billingAccountFacade.checkCreation(entity);
        billingAccountFacade.create(entity);
        entity.setHref(info.getAbsolutePath()+ "/" + Long.toString(entity.getId()));
        billingAccountFacade.edit(entity);
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

        Set<BillingAccount> resultList = findByCriteria(mutableMap);

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
    private Set<BillingAccount> findByCriteria(Map<String, List<String>> criteria) throws BadUsageException {

        List<BillingAccount> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = billingAccountFacade.findByCriteria(criteria, BillingAccount.class);
        } else {
            resultList = billingAccountFacade.findAll();
        }
        if (resultList == null) {
            return new LinkedHashSet<BillingAccount>();
        } else {
            return new LinkedHashSet<BillingAccount>(resultList);
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

        BillingAccount billingAccount = billingAccountFacade.find(id);
        Response response;

        // If the result list (list of bills) is not empty, it conains only 1 unique bill
        if (billingAccount != null) {
            // 200
            if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
                response = Response.ok(billingAccount).build();
            } else {
                fieldSet.add(URIParser.ID_FIELD);
                ObjectNode node = Jackson.createNode(billingAccount, fieldSet);
                response = Response.ok(node).build();
            }
        } else {
            // 404 not found
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }

    @PATCH
    @Path("{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response patch(@PathParam("id") long id, BillingAccount partialUsage) throws BadUsageException, UnknownResourceException {
        Response response = null;
        BillingAccount currentProduct = billingAccountFacade.patchAttributs(id, partialUsage);

        // 200 OK + location
        response = Response.status(Response.Status.OK).entity(currentProduct).build();

        return response;
    }

}
