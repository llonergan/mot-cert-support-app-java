package com.ministryoftesting;

import com.ministryoftesting.api.TimesheetManagerApplication;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TimesheetManagerApplication.class)
@ActiveProfiles("dev")
public class LoginApiTest {
    @Test
    public void testCheckLoginReturnsPositiveResult() {
        AuthPayload authPayload = new AuthPayload("admin@test.com","password123");

        Response response = given()
                .body(authPayload)
                .contentType("application/json")
                .post("http://localhost:8080/v1/auth/login");

        assertEquals(200,response.statusCode());
    }
}
