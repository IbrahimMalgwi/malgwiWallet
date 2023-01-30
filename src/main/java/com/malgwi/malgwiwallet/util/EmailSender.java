package com.malgwi.malgwiwallet.util;

import jakarta.mail.MessagingException;

import java.util.UUID;

public interface EmailSender {
    void send(String to, String email) throws MessagingException;

    String buildEmail (String name, UUID token);
}
