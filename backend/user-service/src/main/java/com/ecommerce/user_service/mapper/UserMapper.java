package com.ecommerce.user_service.mapper;


import com.ecommerce.user_service.dto.UserDTO;
import com.ecommerce.user_service.dto.UserRegistrationDTO;
import com.ecommerce.user_service.entities.User;
import com.ecommerce.user_service.enums.UserRole;
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
                .role(UserRole.ROLE_CLIENT)
                .build();
    }

    public UserDTO toDTO(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .address(entity.getPhone())
                .build();
    }
}
