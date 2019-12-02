/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: RestClientTestSuite.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * date 2019 12 01
 */
package com.algonquincollege.cst8277.rest;

import static com.algonquincollege.cst8277.util.MyConstants.APPLICATION_API_VERSION;
import static com.algonquincollege.cst8277.util.MyConstants.APPLICATION_NAME;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Test;

public class RestClientTestSuite {

    // TODO - create 10 test-cases that send GET/PUT/POST/DELETE messages
    // to REST'ful endpoints for the Banking entities using the JAX-RS
    // ClientBuilder APIs
    WebTarget webTarget;

    @Test
    public void test_01_testBasicAuth() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        URI uri = UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        // URI uri = UriBuilder.fromUri(APPLICATION_NAME +
        // APPLICATION_API_VERSION).scheme("http").host("localhost")
        // .port(8080).build();
        webTarget = client.register(feature).target(uri).path("rest-banking");
        Response response = webTarget.request("APPLICATION_JSON").get();
        assertThat(response.getStatus(), is(200));
    }

    /**
     * Description: Send GET messages to RESTful endpoints for the Account
     * 
     * successfully get an account with id = 1
     */
    @Test
    public void test_02_testAccount() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("account/1");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
    }

    /**
     * Description: Send GET messages to RESTful endpoints for the User
     * 
     * successfully get an user with id = 1
     */
    @Test
    public void test_03_testUser() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        WebTarget webTarget = client.register(feature).target(uri).path("user/1");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getMediaType(), is(not(MediaType.APPLICATION_XML)));
    }

    /**
     * Description: Send GET messages to RESTful endpoints for the Portfolio
     * 
     * successfully get a Portfolio with id = 1
     */
    @Test
    public void test_04_testPortfolio() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        WebTarget webTarget = client.register(feature).target(uri).path("portfolio/1");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
    }

    /**
     * Description: Send GET messages to RESTful endpoints for the Asset
     * 
     * successfully get a Asset with id = 1
     */
    @Test
    public void test_05_tesAsset() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        WebTarget webTarget = client.register(feature).target(uri).path("asset/1");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
    }

    /**
     * Description: Send GET messages to test the resource return type of account
     * 
     * successfully
     */
    @Test
    public void test_06_testgetUserByName() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("user/name/bear");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getMediaType(), is(not(MediaType.APPLICATION_XML)));
    }

    /**
     * Description: Send GET messages to test the resource return type of asset
     * 
     * successfully
     */
    @Test
    public void test_07_testgerAssetByName() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("asset/name/Test");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertTrue(MediaType.APPLICATION_JSON_TYPE.isCompatible(response.getMediaType()));
    }

    /**
     * Description: Send GET messages to test the exist account
     * 
     * successfully
     */
    @Test
    public void test_08_testGetAccount_Saving() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("account/1");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
//        SavingsAccount account = response.readEntity(SavingsAccount.class);
//        assertEquals(1.2, account.getBalance(), 0.0);
    }

    /**
     * Description: Send GET messages to test the resource return type of portfolio
     * 
     * successfully
     */
    @Test
    public void test_09_testgetPortfolioByBalance() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("portfolio/balance/2.3");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertTrue(MediaType.APPLICATION_JSON_TYPE.isCompatible(response.getMediaType()));
    }

    /**
     * Description: Send GET messages to test the exist user with userid
     * 
     * successfully
     */
    @Test
    public void test_010_testGetTypeUser() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("user/4");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
//        SavingsAccount account = response.readEntity(SavingsAccount.class);
//        assertEquals(1.2, account.getBalance(), 0.0);
    }
}