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

    @Test
    public void test_06_testtypeAccount() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("user/3");
        Response response = webTarget.request(APPLICATION_JSON).get();
        assertThat(response.getMediaType(), is(not(MediaType.APPLICATION_XML)));
    }

    @Test
    public void test_07_testtypeAsset() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("asset/1");
        Response response = webTarget.request(APPLICATION_JSON).delete();
        assertTrue(MediaType.APPLICATION_JSON_TYPE.isCompatible(response.getMediaType()));
    }

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

    @Test
    public void test_09_testtypePortfolio() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
        Client client = ClientBuilder.newClient();
        // URI uri =
        // UriBuilder.fromUri("").scheme("http").host("localhost").port(8080).build();
        URI uri = UriBuilder.fromUri(APPLICATION_NAME + APPLICATION_API_VERSION).scheme("http").host("localhost")
                .port(8080).build();
        webTarget = client.register(feature).target(uri).path("portfolio/1");
        Response response = webTarget.request(APPLICATION_JSON).delete();
        assertTrue(MediaType.APPLICATION_JSON_TYPE.isCompatible(response.getMediaType()));
    }

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