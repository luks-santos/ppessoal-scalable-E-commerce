package com.ecommerce.user_service.common;

import com.ecommerce.user_service.dto.UserDTO;
import com.ecommerce.user_service.dto.UserRegistrationDTO;
import com.ecommerce.user_service.entities.User;
import com.ecommerce.user_service.enums.UserRole;

import java.util.ArrayList;

public class UserConstants {

    public static final UserDTO USER_DTO = UserDTO.builder()
            .firstName("First Name")
            .lastName("Last Name")
            .email("user@example.com")
            .phone("phone")
            .address("address")
            .build();

    public static final UserDTO INVALID_USER_DTO = UserDTO.builder()
            .firstName(" ")
            .lastName(" ")
            .email("invalidemail.com")
            .phone(" ")
            .address(" ")
            .build();

    public static final User USER = User.builder()
            .firstName("First Name")
            .lastName("Last Name")
            .email("user@example.com")
            .password("password")
            .address("address")
            .phone("phone")
            .role(UserRole.ROLE_CLIENT)
            .refreshTokens(new ArrayList<>())
            .build();

    public static final User INVALID_USER = User.builder()
            .firstName(" ")
            .lastName(" ")
            .email("user@example.com")
            .password("password")
            .address(" ")
            .phone(" ")
            .role(UserRole.ROLE_CLIENT)
            .refreshTokens(new ArrayList<>())
            .build();

    public static final UserRegistrationDTO USER_REGISTRATION_DTO = UserRegistrationDTO.builder()
            .firstName("First Name")
            .lastName("Last Name")
            .email("user@example.com")
            .password("password")
            .address("address")
            .phone("phone")
            .build();

    public static final UserRegistrationDTO INVALID_USER_REGISTRATION_DTO = UserRegistrationDTO.builder()
            .firstName(" ")
            .lastName(" ")
            .email("userexample.com")
            .password(" ")
            .address(" ")
            .phone(" ")
            .build();
}
