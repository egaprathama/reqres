package com.reqres;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import com.reqres.endpoint.EndPoint;
import com.reqres.pojo.LoginRequest;
import com.reqres.pojo.LoginResponseFailed;
import com.reqres.pojo.LoginResponseSuccessfull;

public class LoginTest {
    @Test
    public void testSuccessfulLogin() {
        LoginRequest request = new LoginRequest("eve.holt@reqres.in", "cityslicka");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .post(EndPoint.LOGIN);

        LoginResponseSuccessfull loginResponse = response.as(LoginResponseSuccessfull.class);

        int statusCode = response.getStatusCode();
        String token = loginResponse.getToken();

        assertEquals(statusCode, 200, "Incorrect status code");
        assertNotNull(token, "Token should not be null");
    }

    @Test
    public void testFailedLogin() {
        LoginRequest request = new LoginRequest("peter@klaven", null);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .post(EndPoint.LOGIN);

        LoginResponseFailed errorMessage = response.as(LoginResponseFailed.class);

        int statusCode = response.getStatusCode();
        String error = errorMessage.getError();

        assertEquals(error, "Missing password", "Incorrect error message");
        assertEquals(statusCode, 400, "Incorrect status code");
    }
}