package com.reqres;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import java.util.List;
import com.reqres.endpoint.EndPoint;
import com.reqres.pojo.ListUsersResponse;

public class ListUsersTest {
    @Test
    public void testListUsers() {
        Response response = RestAssured.get(EndPoint.LIST_USERS);

        ListUsersResponse listUsersResponse = response.as(ListUsersResponse.class);
        List<ListUsersResponse.UserData> users = listUsersResponse.getData();
        ListUsersResponse.UserData user1 = users.get(0);

        int statusCode = response.getStatusCode();

        assertEquals(statusCode, 200, "Incorrect status code");
        assertEquals(users.size(), 6, "Incorrect number of users");
        assertEquals(user1.getId(), 7, "Incorrect user ID");
        assertEquals(user1.getEmail(), "michael.lawson@reqres.in", "Incorrect user email");
    }
}