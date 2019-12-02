/**************************
 * File: AssetResource.java
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

import com.algonquincollege.cst8277.ejbs.AssetBean;
import com.algonquincollege.cst8277.models.Asset;
import com.algonquincollege.cst8277.util.MyConstants;

@Path("asset")
public class AssetResource {

    @EJB
    protected AssetBean bean;

    /**
     * Description: Retrieve an asset by id
     * 
     * @param id
     * @return OK if Asset is existed
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssets(@PathParam("id") int id) {
        List<Asset> listResult = bean.getAsset(id);
        return Response.ok(listResult).build();
    }

    @GET
    @Path("/name/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssetsByName(@PathParam("name") String name) {
        List<Asset> listResult = bean.getAssetByName(name);
        return Response.ok(listResult).build();
    }

    /**
     * Description: Create an asset
     * 
     * @param newTemp
     * @return OK if an asset is successful created
     */

    @POST
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAsset(Asset newTemp) {
        Asset add = bean.addAsset(newTemp);
        return Response.ok(add).build();
    }

    /**
     * Description: Delete an asset by Id
     * 
     * @param id
     * @return OK if an asset is successful deleted
     */
    @DELETE
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteAsset(@PathParam("id") int id) {
        Asset delete = bean.deleteAsset(id);
        return Response.ok(delete).build();
    }

    /**
     * Description: Update an asset by Id
     * 
     * @param id, asset ti be updated
     * @return OK if an asset is successful updated
     */
    @PUT
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAsset(@PathParam("id") int id, Asset assetToBeUpdated) {
        bean.updateAsset(id, assetToBeUpdated);
        return Response.ok(assetToBeUpdated).build();
    }
}
