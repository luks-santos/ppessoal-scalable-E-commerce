package com.ecommerce.user_service.controllers;

import com.ecommerce.user_service.dto.AuthResponseDTO;
import com.ecommerce.user_service.dto.UserRegistrationDTO;
import com.ecommerce.user_service.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService service;

    @Operation(summary = "Authenticate a user", description = "First, log in with your credentials by clicking on \uD83D\uDD12 Authorize in Swagger. Then, use the endpoint to authenticate the user.")
    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponseDTO> authenticateUser(Authentication authentication, HttpServletResponse response) {
        return ResponseEntity.ok(service.getJwtTokensAfterAuthentication(authentication, response));
    }

    @Operation(summary = "Get a new access token", description = "Use the refresh token, this token is found in a cookie named 'refresh_token'")
    @PostMapping("/refresh-token")
    public ResponseEntity<AuthResponseDTO> getAccessToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return ResponseEntity.ok(service.getAccessTokenUsingRefreshToken(authorizationHeader));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponseDTO> registerUser(@RequestBody @Valid UserRegistrationDTO userRegistrationDto,
                                                        HttpServletResponse httpServletResponse) {

        log.info("[AuthController:registerUser]Signup Process Started for user:{}", userRegistrationDto.email());
        return ResponseEntity.ok(service.registerUser(userRegistrationDto, httpServletResponse));
    }
}
