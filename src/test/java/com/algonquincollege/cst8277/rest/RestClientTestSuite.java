/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: RestClientTestSuite.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 *
 * @date 2019 10
 */
package com.algonquincollege.cst8277.rest;

import static com.algonquincollege.cst8277.util.MyConstants.APPLICATION_API_VERSION;
import static com.algonquincollege.cst8277.util.MyConstants.APPLICATION_NAME;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Test;

public class RestClientTestSuite {

    // TODO - create 10 test-cases that send GET/PUT/POST/DELETE messages
    // to REST'ful endpoints for the Banking entities using the JAX-RS
    // ClientBuilder APIs

    @Test
    public void testBasicAuth() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();

        WebTarget webTarget = client.register(feature).target(uri).path("user");

        Response response = webTarget.request("APPLICATION_JSON").get();
        assertThat(response.getStatus(), is(200));

    }
}