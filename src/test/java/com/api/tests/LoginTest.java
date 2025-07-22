package com.api.tests;

import com.api.models.request.payloads.LoginReqPayload;
import com.api.models.response.payloads.LoginResPayload;
import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test(description = "login verification test", groups = {"reg", "login"},enabled = false)
    public void verifyStatusCodeForValidLogin() {

        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);

        Assert.assertEquals(rs.getStatusCode(), 200);


    }

    @Test(groups = {"reg", "login"},enabled = false)
    public void verifyStatusCodeForInValidEmailLogin() {

        LoginReqPayload req = new LoginReqPayload("ak_160819", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        Assert.assertEquals(rs.getStatusCode(), 401);


    }

    @Test(groups = {"reg", "login"},enabled = false)
    public void verifyStatusCodeForInValidPassLogin() {

        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@12");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        Assert.assertEquals(rs.getStatusCode(), 401);


    }

    @Test(groups = {"reg", "login"})
    public void validateTheEmailIdAfterLogin() {
        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        LoginResPayload lg = rs.getBody().as(LoginResPayload.class);
        System.out.println(lg.getToken());
        Assert.assertEquals(lg.getEmail(), "puluthii181@gmail.com");

    }

}
