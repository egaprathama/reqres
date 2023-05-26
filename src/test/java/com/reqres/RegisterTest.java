package com.reqres;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import com.reqres.endpoint.EndPoint;
import com.reqres.pojo.RegisterRequest;
import com.reqres.pojo.RegisterResponseSuccessfull;
import com.reqres.pojo.RegisterResponseFailed;

public class RegisterTest {
    @Test
    public void testSuccessfulRegister() {
        RegisterRequest request = new RegisterRequest("eve.holt@reqres.in", "pistol");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .post(EndPoint.REGISTER);

        RegisterResponseSuccessfull registerResponse = response.as(RegisterResponseSuccessfull.class);

        int statusCode = response.getStatusCode();
        int id = registerResponse.getId();
        String token = registerResponse.getToken();

        assertEquals(statusCode, 200, "Incorrect status code");
        assertNotNull(id, "ID should not be null");
        assertNotNull(token, "Token should not be null");
    }

    @Test
    public void testFailedRegister() {
        RegisterRequest request = new RegisterRequest("sydney@fife", null);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .post(EndPoint.REGISTER);

        RegisterResponseFailed errorMessage = response.as(RegisterResponseFailed.class);

        int statusCode = response.getStatusCode();
        String error = errorMessage.getError();

        assertEquals(statusCode, 400, "Incorrect status code");
        assertEquals(error, "Missing password", "Incorrect error message");
    }
}