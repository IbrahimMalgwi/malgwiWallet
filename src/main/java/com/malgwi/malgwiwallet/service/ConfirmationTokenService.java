package com.malgwi.malgwiwallet.service;

import com.malgwi.malgwiwallet.model.ConfirmationToken;
import com.malgwi.malgwiwallet.model.User;

import java.util.UUID;

public interface ConfirmationTokenService {
    String confirmToken(ConfirmationToken confirmationToken);
    UUID generateToken();

    void createToken(UUID token, User user);
}
