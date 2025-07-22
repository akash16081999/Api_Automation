package com.api.tests;

import com.api.models.request.payloads.LoginReqPayload;
import com.api.models.response.payloads.AccountControllerResPayload;
import com.api.models.response.payloads.LoginResPayload;
import com.api.services.AccountController;
import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountControllerTest {

    @Test
    public void validateGetAccountDetailsReqStatusCode() {
        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);
        AccountController ac = new AccountController();
        res = ac.getAccountDetails(login.getToken());
        Assert.assertEquals(res.getStatusCode(), 200);

    }

    @Test
    public void validateGetAccountDetailsResBody() {
        AuthService service = new AuthService();
        Response res = service.loginRequest(new LoginReqPayload("ak_16081999", "test@123"));
        LoginResPayload login = res.getBody().as(LoginResPayload.class);
        AccountController ac = new AccountController();
        res = ac.getAccountDetails(login.getToken());

        AccountControllerResPayload acRes = res.getBody().as(AccountControllerResPayload.class);
        Assert.assertEquals(acRes.getAccountNumber(), "3085087902");
        Assert.assertEquals(acRes.getAccountType(), "SAVINGS");
        Assert.assertEquals(acRes.getStatus(), "ACTIVE");
        Assert.assertEquals(acRes.getBranch(), "MAIN_BRANCH");
        Assert.assertEquals(acRes.getOwnerName(), "Akash Narayanan");


    }

}
