/**************************
 * File: PortfolioResource.java
 * Course materials (19F) CST 8277
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * @date 2019 12 01
 */
package com.algonquincollege.cst8277.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.algonquincollege.cst8277.ejbs.PortfolioBean;
import com.algonquincollege.cst8277.models.Portfolio;
import com.algonquincollege.cst8277.util.MyConstants;

@Path("portfolio")
public class PortfolioResource {

    @EJB
    protected PortfolioBean bean;

    /**
     * Description: Retrieve a Portfolio by id
     * 
     * @param Portfolio Id
     * @return OK if Portfolio is existed
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPortfolios(@PathParam("id") int id) {
        List<Portfolio> listResult = bean.getPortfolio(id);
        return Response.ok(listResult).build();
    }

    @GET
    @Path("/balance/{b}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPortfolioByBalance(@PathParam("b") double b) {
        List<Portfolio> accounts = bean.getPortfolioByBalance(b);
        return Response.ok(accounts).build();
    }

    /**
     * Description: Create a Portfolio
     * 
     * @param Portfolio Id, new Portfolio
     * @return OK if Portfolio is successful created
     */

    @POST
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPortfolio(Portfolio newTemp) {
        Portfolio add = bean.addPortfolio(newTemp);
        return Response.ok(add).build();
    }

    /**
     * Description: Delete a Portfolio by Id
     * 
     * @param Portfolio Id
     * @return OK if Portfolio is successful deleted
     */
    @DELETE
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deletePortfolio(@PathParam("id") int id) {
        Portfolio delete = bean.deletePortfolio(id);
        return Response.ok(delete).build();
    }

    /**
     * Description: Delete a Portfolio by Id
     * 
     * @param Portfolio Id, Portfolio to be updated
     * @return OK if Portfolio is successful updated
     */
    @PUT
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updatePortfolio(@PathParam("id") int id, Portfolio portfolioToBeUpdated) {
        // accountToBeUpdated.setId(id);
        Portfolio account = bean.updatePortfolio(id, portfolioToBeUpdated);
        return Response.ok(account).build();
    }
}
