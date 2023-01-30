package com.malgwi.malgwiwallet.service;

import com.malgwi.malgwiwallet.dto.request.RegistrationRequest;
import com.malgwi.malgwiwallet.model.User;
import jakarta.mail.MessagingException;

public interface UserService {
    String register(RegistrationRequest registrationRequest) throws MessagingException;
}
