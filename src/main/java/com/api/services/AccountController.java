package com.api.services;

import com.api.base.BaseService;
import io.restassured.response.Response;

public class AccountController extends BaseService {
    private static final String BASE_PATH = "api/accounts";


    public void accounts() {

    }

    public Response getAccountDetails(String token) {
        setToken(token);
        return getRequest(BASE_PATH + "/3085087902");
    }


}
