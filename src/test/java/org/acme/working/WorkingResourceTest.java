package org.acme.working;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class WorkingResourceTest {
    @Test
    public void test_ClientRequestFilter_sendAsExpected() {
        given()
          .when()
          .get("/working")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy (from Test)"));
    }
}
