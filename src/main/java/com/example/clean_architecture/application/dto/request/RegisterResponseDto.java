package com.example.clean_architecture.application.dto.request;

import org.springframework.http.HttpStatus;

import com.example.clean_architecture.domain.model.user.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RegisterResponseDto {
    private String message;
    private UserRole role;

    public RegisterResponseDto( String message, UserRole role) {
        this.message = message;
        this.role = role;
    }
}
