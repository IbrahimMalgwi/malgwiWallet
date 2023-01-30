package com.malgwi.malgwiwallet.controller;

import com.malgwi.malgwiwallet.dto.request.RegistrationRequest;
import com.malgwi.malgwiwallet.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) throws MessagingException {
        return new ResponseEntity<>(userService.register(registrationRequest), HttpStatus.OK);
    }

}
