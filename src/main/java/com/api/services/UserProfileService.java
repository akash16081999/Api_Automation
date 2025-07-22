package com.api.services;

import com.api.base.BaseService;
import com.api.models.request.payloads.UserProfileReqPayload;
import io.restassured.response.Response;

public class UserProfileService extends BaseService {

    private static final String Base_PATH = "api/users/";

    public Response getProfileDetails(String token) {
        setToken(token);
        return getRequest(Base_PATH + "profile");


    }

    public Response updateUserProfile(UserProfileReqPayload payload,String token) {
        setToken(token);
        return putRequest(payload, Base_PATH + "profile");

    }


}
