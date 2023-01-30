package com.malgwi.malgwiwallet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    private User user;
}
