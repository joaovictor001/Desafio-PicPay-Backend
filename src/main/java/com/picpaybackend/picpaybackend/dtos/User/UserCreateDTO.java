package com.picpaybackend.picpaybackend.dtos.User;

import com.picpaybackend.picpaybackend.enums.UserType;

import java.math.BigDecimal;

public record UserCreateDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
}
