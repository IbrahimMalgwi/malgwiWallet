package com.malgwi.malgwiwallet.controller;

import com.malgwi.malgwiwallet.model.ConfirmationToken;
import com.malgwi.malgwiwallet.service.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/confirmToken")
public class ConfirmationTokenController {

    @Autowired
    ConfirmationTokenService confirmationTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> confirmToken (@RequestBody ConfirmationToken confirmationToken){
        return null;
    }
}
