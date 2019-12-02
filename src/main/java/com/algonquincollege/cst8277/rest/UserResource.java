/**************************
 * File: UserResource.java
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

import com.algonquincollege.cst8277.ejbs.UserBean;
import com.algonquincollege.cst8277.models.User;
import com.algonquincollege.cst8277.util.MyConstants;

@Path("user")
public class UserResource {

    @EJB
    protected UserBean bean;

    /**
     * Description: Retrieve a User by id
     * 
     * @param id
     * @return OK if User is existed
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(@PathParam("id") int id) {
        List<User> listResult = bean.getUsersFor(id);
        return Response.ok(listResult).build();
    }

    @GET
    @Path("/name/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByName(@PathParam("name") String name) {
        List<User> listResult = bean.getUsersByName(name);
        return Response.ok(listResult).build();
    }

    /**
     * Description: Create a new User
     * 
     * @param newTemp
     * @return OK if User is successful created
     */

    @POST
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User newTemp) {
        User add = bean.addUser(newTemp);
        return Response.ok(add).build();
    }

    /**
     * Description: Delelte a User by Id
     * 
     * @param id
     * @return OK if User is successful deleted
     */
    @DELETE
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        User delete = bean.deleteUser(id);
        return Response.ok(delete).build();
    }

    /**
     * Description: Update a User by Id
     * 
     * @param id, userToBeUpdated
     * @return OK if User is successful updated
     */
    @PUT
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id, User userToBeUpdated) {
        // accountToBeUpdated.setId(id);
        bean.updateUser(id, userToBeUpdated);
        return Response.ok(userToBeUpdated).build();
    }
}
