package com.api.tests;

import com.api.models.request.payloads.LoginReqPayload;
import com.api.models.request.payloads.UserProfileReqPayload;
import com.api.models.response.payloads.LoginResPayload;
import com.api.models.response.payloads.UserProfileResPayload;
import com.api.services.AuthService;
import com.api.services.UserProfileService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest {

    @Test(groups ={"reg","profile"})
    public void updateFirstName() {
                   // ------> Generate Token in the first call
        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        LoginResPayload lg = rs.getBody().as(LoginResPayload.class);

                   // --------------> Pass the token to the below call
        UserProfileService userService = new UserProfileService();
        rs = userService.updateUserProfile(new UserProfileReqPayload.Builder().setFirstName("Akash").setLastName("Narayanan").setEmail("puluthii11@gmail.com").setMobileNumber("9551827355").build(), lg.getToken());
        UserProfileResPayload userprofile = rs.getBody().as(UserProfileResPayload.class);
        Assert.assertEquals(userprofile.getFirstName(), "Akash");

    }

    @Test(groups ={"reg","profile"})
    public void updateLastName() {
                   // ------> Generate Token in the first call
        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        LoginResPayload lg = rs.getBody().as(LoginResPayload.class);

                   // --------------> Pass the token to the below call
        UserProfileService userService = new UserProfileService();
        rs = userService.updateUserProfile(new UserProfileReqPayload.Builder().setFirstName("Akash").setLastName("Narayanan").setEmail("puluthii11@gmail.com").setMobileNumber("9551827355").build(), lg.getToken());
        UserProfileResPayload userprofile = rs.getBody().as(UserProfileResPayload.class);
        Assert.assertEquals(userprofile.getLastName(), "Narayanan");

    }

    @Test(groups ={"reg","profile"})
    public void updateEmail() {
                    // ------> Generate Token in the first call
        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        LoginResPayload lg = rs.getBody().as(LoginResPayload.class);

                     // --------------> Pass the token to the below call
        UserProfileService userService = new UserProfileService();
        rs = userService.updateUserProfile(new UserProfileReqPayload.Builder().setFirstName("Akash").setLastName("Narayanan").setEmail("puluthii11@gmail.com").setMobileNumber("9551827355").build(), lg.getToken());
        UserProfileResPayload userprofile = rs.getBody().as(UserProfileResPayload.class);
        Assert.assertEquals(userprofile.getEmail(), "puluthii11@gmail.com");


    }

    @Test(groups ={"reg","profile"})
    public void updateMobileNumber() {
                    //------> Generate Token in the first call.
        LoginReqPayload req = new LoginReqPayload("ak_16081999", "test@123");
        AuthService service = new AuthService();
        Response rs = service.loginRequest(req);
        LoginResPayload lg = rs.getBody().as(LoginResPayload.class);


                    // --------------> Pass the token to the below call
        UserProfileService userService = new UserProfileService();
        rs = userService.updateUserProfile(new UserProfileReqPayload.Builder().setFirstName("Akash").setLastName("Narayanan").setEmail("puluthii11@gmail.com").setMobileNumber("9551827355").build(), lg.getToken());
        UserProfileResPayload userprofile = rs.getBody().as(UserProfileResPayload.class);
        Assert.assertEquals(userprofile.getMobileNumber(),Long.parseLong("9551827355"));


    }

}
