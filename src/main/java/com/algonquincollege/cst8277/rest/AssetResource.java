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

import com.algonquincollege.cst8277.ejbs.AssetBean;
import com.algonquincollege.cst8277.models.Asset;
import com.algonquincollege.cst8277.util.MyConstants;

@Path("asset")
public class AssetResource {

    @EJB
    protected AssetBean bean;

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssets(@PathParam("id") int id) {
        List<Asset> listResult = bean.getAsset(id);
        return Response.ok(listResult).build();
    }

    @POST
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response addAsset(@PathParam("id") int id, Asset newTemp) {
        Asset add = bean.addAsset(newTemp);
        return Response.ok(add).build();
    }

    @DELETE
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteAsset(@PathParam("id") int id) {
        Asset delete = bean.deleteAsset(id);
        return Response.ok(delete).build();
    }

    @PUT
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAsset(@PathParam("id") int id, Asset assetToBeUpdated) {
        // accountToBeUpdated.setId(id);
//        AccountBase account = bean.updateBankAccount(id, accountToBeUpdated);
//        return Response.ok(account).build();
        return null;
    }
}
