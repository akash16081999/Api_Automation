package com.api.services;

import com.api.base.BaseService;
import com.api.models.request.payloads.LoginReqPayload;
import com.api.models.request.payloads.ResetPassReqPayload;
import com.api.models.request.payloads.SignupReqPayload;
import io.restassured.response.Response;

public class AuthService extends BaseService {

    private static final String Base_PATH = "api/auth/";


    public Response loginRequest(LoginReqPayload payload) {
        return postRequest(payload, Base_PATH + "login");


    }

    public Response forgotPassRequest(Object payload) {
        return postRequest(payload, Base_PATH + "forgot-password");
    }

    public Response resetPassRequest(ResetPassReqPayload Payload, String token) {
        return postRequest(Payload, Base_PATH + "reset-password", token);
    }

    public Response signupRequest(SignupReqPayload payload) {
        return postRequest(payload, Base_PATH + "signup");
    }
}
