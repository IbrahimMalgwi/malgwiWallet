package com.malgwi.malgwiwallet.service;

import com.malgwi.malgwiwallet.dto.request.ConfirmationTokenRequest;
import com.malgwi.malgwiwallet.dto.request.ResendTokenRequest;
import com.malgwi.malgwiwallet.model.ConfirmationToken;
import com.malgwi.malgwiwallet.model.User;
import jakarta.mail.MessagingException;

import java.util.UUID;

public interface ConfirmationTokenService {
    String confirmToken(ConfirmationTokenRequest confirmationTokenRequest);
    String generateToken();
    void createToken(String token, User user);
    String resendToken(ResendTokenRequest resendTokenRequest) throws MessagingException;
}
