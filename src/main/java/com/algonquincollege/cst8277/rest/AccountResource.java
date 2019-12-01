/**************************
 * File: AccountResource.java
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
     * @param Account Id
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

    @GET
    @Path("/balance/{b}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccounts(@PathParam("b") double b) {
        List<AccountBase> accounts = bean.getBankAccountsByBalance(b);
        return Response.ok(accounts).build();
    }

    /**
     * Description: Create a bank account id
     * 
     * @param id, new account to be created
     * @return OK if bank account is successful created
     */

    @POST
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAccount(AccountBase newAccountToBeCreated) {
        AccountBase account = bean.addBankAccount(newAccountToBeCreated);
        return Response.ok(account).build();
    }

    /**
     * Description: Delete a bank account by id
     * 
     * @param Account Id
     * @return OK if bank account is successful deleted
     */
    @DELETE
    @RolesAllowed(MyConstants.ADMIN_ROLE)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteAccount(@PathParam("id") int id) {
        AccountBase account = bean.deleteBankAccount(id);
        return Response.ok(account).build();
    }

    /**
     * Description: Update a bank account by id
     * 
     * @param Account Id, account to be updated
     * @return OK if bank account is successful updated
     */
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
