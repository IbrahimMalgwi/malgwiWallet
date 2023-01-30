package com.malgwi.malgwiwallet.repository;

import com.malgwi.malgwiwallet.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
}
