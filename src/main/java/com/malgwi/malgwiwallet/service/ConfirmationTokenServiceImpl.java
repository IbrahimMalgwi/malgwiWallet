package com.malgwi.malgwiwallet.service;

import com.malgwi.malgwiwallet.dto.request.ConfirmationTokenRequest;
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

    @Autowired
    private UserService userService;

    @Override
    public String confirmToken(ConfirmationTokenRequest confirmationTokenRequest) {
        ConfirmationToken savedToken = confirmationTokenRepository
                .findByToken(confirmationTokenRequest.getTokenNumber())
                .orElseThrow(()-> new IllegalArgumentException("Token does not exist"));
        if (savedToken.getExpiredAt().isBefore(LocalDateTime.now())) return "token has expired";
        savedToken.setConfirmedAt(LocalDateTime.now());
        userService.enableUser(savedToken.getUser());
        confirmationTokenRepository.save(savedToken);
        return "Token confirmed";
    }

    @Override
    public String generateToken() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    @Override
    public void createToken(String token, User user) {
        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setToken(token);
        confirmationToken.setCreatedAt(LocalDateTime.now());
        confirmationToken.setExpiredAt(LocalDateTime.now().plusMinutes(10));
        confirmationToken.setUser(user);
        confirmationTokenRepository.save(confirmationToken);
    }
}
