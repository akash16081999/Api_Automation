package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileService;
import com.api.models.request.payloads.ForgotPassReqPayloads;
import com.api.models.request.payloads.LoginReqPayload;
import com.api.models.request.payloads.ResetPassReqPayload;
import com.api.models.request.payloads.SignupReqPayload;
import com.api.models.response.payloads.ForgotPassResPayload;
import com.api.models.response.payloads.LoginResPayload;
import com.api.models.response.payloads.SignupResPayload;
import com.api.models.response.payloads.UserProfileResPayload;
import com.beust.ah.A;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest {

    @Test(description = "login verification test")
    public void loginTestVerification() {

        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        LoginResPayload lg = rs.as(LoginResPayload.class);
        String token = lg.getToken();
        System.out.println(token);
        UserProfileService up = new UserProfileService();
        Response rss = up.getProfileDetails(token);
        UserProfileResPayload urs=rss.as(UserProfileResPayload.class);
        System.out.println(urs.getLastName());


    }
}
