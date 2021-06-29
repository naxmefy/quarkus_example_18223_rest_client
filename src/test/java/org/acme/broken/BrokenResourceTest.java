package org.acme.broken;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BrokenResourceTest {
    @Test
    public void test_ClientHeadersFactory_notSendAndResultInUnhandledException() {
        given()
          .when()
          .get("/broken")
          .then()
             .statusCode(500);
    }

    @Test
    public void test_ClientHeadersFactory_sendAsExpected() {
        given()
          .when()
          .get("/broken/working")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy (from Test)"));
    }
}
