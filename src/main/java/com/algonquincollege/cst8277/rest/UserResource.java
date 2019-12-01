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

import com.algonquincollege.cst8277.ejbs.UserBean;
import com.algonquincollege.cst8277.models.AccountBase;
import com.algonquincollege.cst8277.models.User;
import com.algonquincollege.cst8277.util.MyConstants;

@Path("user")
public class UserResource {

    @EJB
    protected UserBean bean;

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(@PathParam("id") int id) {
        List<User> listResult = bean.getUsersFor(id);
        return Response.ok(listResult).build();
    }

    @POST
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response addUser(@PathParam("id") int id, User newTemp) {
        User add = bean.addUser(newTemp);
        return Response.ok(add).build();
    }

    @DELETE
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        User delete = bean.deleteUser(id);
        return Response.ok(delete).build();
    }

    @PUT
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAccount(@PathParam("id") int id, AccountBase accountToBeUpdated) {
        // accountToBeUpdated.setId(id);
        AccountBase account = bean.updateBankAccount(id, accountToBeUpdated);
        return Response.ok(account).build();
    }
}
