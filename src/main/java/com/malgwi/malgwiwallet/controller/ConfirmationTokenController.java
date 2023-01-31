package com.malgwi.malgwiwallet.controller;

import com.malgwi.malgwiwallet.dto.request.ConfirmationTokenRequest;
import com.malgwi.malgwiwallet.service.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/token")
public class ConfirmationTokenController {

    @Autowired
    ConfirmationTokenService confirmationTokenService;

    @PostMapping("/confirmToken")
    public ResponseEntity<?> confirmToken (@RequestBody ConfirmationTokenRequest confirmationTokenRequest){
        return new ResponseEntity<>(confirmationTokenService.confirmToken(confirmationTokenRequest), HttpStatus.OK);
    }


}
