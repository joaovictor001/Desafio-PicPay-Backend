package com.picpaybackend.picpaybackend.repository;

import com.picpaybackend.picpaybackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReposity extends JpaRepository<User,Long> {
    Optional<User>findUserByDocument(String document);
    Optional<User>findUserById(Long id);
}
