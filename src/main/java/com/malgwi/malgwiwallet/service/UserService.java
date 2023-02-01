package com.malgwi.malgwiwallet.service;

import com.malgwi.malgwiwallet.dto.request.ForgotPasswordRequest;
import com.malgwi.malgwiwallet.dto.request.LoginRequest;
import com.malgwi.malgwiwallet.dto.request.RegistrationRequest;
import com.malgwi.malgwiwallet.model.User;
import jakarta.mail.MessagingException;

public interface UserService {
    String register(RegistrationRequest registrationRequest) throws MessagingException;

    void enableUser(User user);
    User findUserByEmail(String email);
    String login(LoginRequest loginRequest);

    String forgotPassword(ForgotPasswordRequest forgotPasswordRequest, Long uerId);
}
