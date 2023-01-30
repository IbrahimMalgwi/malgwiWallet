package com.malgwi.malgwiwallet.service;

import com.malgwi.malgwiwallet.model.ConfirmationToken;
import com.malgwi.malgwiwallet.model.User;
import com.malgwi.malgwiwallet.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public String confirmToken(ConfirmationToken confirmationToken) {
        return null;
    }

    @Override
    public UUID generateToken() {
        return UUID.randomUUID();
    }

    @Override
    public void createToken(UUID token, User user) {
        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setToken(token);
        confirmationToken.setCreatedAt(LocalDateTime.now());
        confirmationToken.setExpiredAt(LocalDateTime.now().plusMinutes(10));
        confirmationToken.setUser(user);

        confirmationTokenRepository.save(confirmationToken);

    }
}
