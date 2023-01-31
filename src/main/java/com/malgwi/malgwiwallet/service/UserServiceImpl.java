package com.malgwi.malgwiwallet.service;

import com.malgwi.malgwiwallet.dto.request.RegistrationRequest;
import com.malgwi.malgwiwallet.model.Role;
import com.malgwi.malgwiwallet.model.User;
import com.malgwi.malgwiwallet.repository.UserRepository;
import com.malgwi.malgwiwallet.util.EmailSender;
import com.malgwi.malgwiwallet.util.Validator;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Override
    public String register(RegistrationRequest registrationRequest) throws MessagingException {
        if(!Validator.isValidEmailAddress(registrationRequest.getEmail())) throw new RuntimeException("Email format is not valid ");

        if (!Validator.isValidPassword(registrationRequest.getPassword())) throw new RuntimeException("Password format is not valid ");

        if (userRepository.findUserByEmailIgnoreCase(registrationRequest.getEmail()).isPresent()) throw new RuntimeException("User Already Exist");

        User savedUser = new User();
        savedUser.setFirstName(registrationRequest.getFirstName());
        savedUser.setLastName(registrationRequest.getLastName());
        savedUser.setEmail(registrationRequest.getEmail());
        savedUser.setPassword(registrationRequest.getPassword());
        savedUser.setRole(Role.USER);
        userRepository.save(savedUser);

        String token = confirmationTokenService.generateToken();

        confirmationTokenService.createToken(token, savedUser);

        emailSender.send(savedUser.getEmail(), emailSender.buildEmail(savedUser.getFirstName(), token));

        return "Registered Successfully";
    }

    @Override
    public void enableUser(User user) {
        user.setEnable(true);
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmailIgnoreCase(email)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
    }
}
