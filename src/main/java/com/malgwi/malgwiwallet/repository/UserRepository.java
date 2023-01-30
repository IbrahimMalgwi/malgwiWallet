package com.malgwi.malgwiwallet.repository;

import com.malgwi.malgwiwallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailIgnoreCase(String email);


}
