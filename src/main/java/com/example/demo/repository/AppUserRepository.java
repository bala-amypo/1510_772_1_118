package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    // check if username already exists
    boolean existsByUsername(String username);

    // check if email already exists
    boolean existsByEmail(String email);

    // optional: used for login / auth
    Optional<AppUser> findByUsername(String username);
}
