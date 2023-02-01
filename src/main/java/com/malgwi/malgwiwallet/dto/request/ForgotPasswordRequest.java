package com.malgwi.malgwiwallet.dto.request;

import lombok.Data;

@Data
public class ForgotPasswordRequest {
    private String newPassword;
    private String confirmPassword;
}
