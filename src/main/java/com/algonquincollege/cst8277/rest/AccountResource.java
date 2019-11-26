package com.algonquincollege.cst8277.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.algonquincollege.cst8277.ejbs.BankingBean;
import com.algonquincollege.cst8277.models.AccountBase;

@Path("account")
public class AccountResource {

    @EJB
    protected BankingBean bean;

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccounts(@PathParam("id") int id) {
        List<AccountBase> accounts = bean.getBankAccountsFor(id);
        return Response.ok(accounts).build();
    }

}
