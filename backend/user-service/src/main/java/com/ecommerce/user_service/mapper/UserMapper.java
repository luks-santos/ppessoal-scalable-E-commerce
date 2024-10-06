package com.ecommerce.user_service.mapper;


import com.ecommerce.user_service.dtos.UserRegistrationDTO;
import com.ecommerce.user_service.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User toEntity(UserRegistrationDTO dto) {
        return User.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .address(dto.address())
                .phone(dto.phone())
                .role(dto.role())
                .build();
    }
}
