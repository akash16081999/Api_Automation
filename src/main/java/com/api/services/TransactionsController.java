package com.api.services;

import com.api.base.BaseService;
import io.restassured.response.Response;

public class TransactionsController extends BaseService {

    private static final String BASE_PATH = "api/transactions/";

    public Response deposit(Object payload,String token) {
        setToken(token);
        return postRequest(payload, BASE_PATH + "deposit");

    }

    public Response getTransactionHistory(String token) {
        setToken(token);
        return getRequest(BASE_PATH + "history","3085087902",0,50);
    }

    public Response transfer(Object payload, String token) {
        setToken(token);
        return postRequest(payload, BASE_PATH + "transfer");
    }

    public Response Withdraw(Object payload, String token) {
        setToken(token);
        return postRequest(payload, BASE_PATH + "withdraw");
    }

}
