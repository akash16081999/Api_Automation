package com.api.models.request.payloads;

public class ResetPassReqPayload {

    String newPassword;
    String confirmPassword;
    String currentPassword;

    public ResetPassReqPayload(String confirmPassword, String currentpassword, String newPassword) {
        this.confirmPassword = confirmPassword;
        this.newPassword = newPassword;
        this.currentPassword = currentpassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    @Override
    public String toString() {
        return "ResetPassReqPayload{" +
                "confirmPassword='" + confirmPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
