package com.api.base;

import io.restassured.response.Response;

public class UserProfileService extends BaseService {

    private static final String Base_PATH = "api/users/";

    public Response getProfileDetails(String token) {
        setToken(token);
        return getRequest(Base_PATH + "profile");


    }


}
