package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    private final static String BASE_URI = "http://64.227.160.186:8080/";
    private RequestSpecification requestSpecification;

    BaseService() {

        requestSpecification = RestAssured.given().baseUri(BASE_URI).header("Content-Type", "application/json");

    }

    protected Response postRequest(Object payload, String endpoint) {

        return requestSpecification.body(payload).post(endpoint);
    }

    protected Response postRequest(Object payload, String endpoint, String token) {

        return requestSpecification.auth().oauth2(token).body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);

    }

    protected void setToken(String token) {
        requestSpecification.header("Authorization", "Bearer"+" "+ token);

    }

}
