/**************************
 * File: AccountResource.java
 * Course materials (19F) CST 8277
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * @date 2019 11 30
 */
package com.algonquincollege.cst8277.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import com.algonquincollege.cst8277.ejbs.BankingBean;
import com.algonquincollege.cst8277.models.AccountBase;
import com.algonquincollege.cst8277.util.MyConstants;

@Path("account")
public class AccountResource {

    @EJB
    protected BankingBean bean;

    /**
    * Description: Retrieve a bank account by id
    * 
    * @return OK if bank account existed
    */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccounts(@PathParam("id") int id) {
        List<AccountBase> accounts = bean.getBankAccountsFor(id);
        return Response.ok(accounts).build();
    }

    /**
    * Description: Create a bank account by id
    * 
    * @return OK if bank account is successful created
    */
    @POST
    @Operation(description = "Sends a mesage to the server")
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response addAccount(@PathParam("id") int id, AccountBase newAccountToBeCreated) {
        AccountBase account = bean.addBankAccount(newAccountToBeCreated);
        return Response.ok(account).build();
    }

}
