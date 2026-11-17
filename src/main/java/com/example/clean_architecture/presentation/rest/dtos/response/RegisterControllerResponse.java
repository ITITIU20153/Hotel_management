package com.example.clean_architecture.presentation.rest.dtos.response;

import com.example.clean_architecture.application.dto.RegisterResponseDto;
import com.example.clean_architecture.domain.model.user.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RegisterControllerResponse {
    private String message;
    private UserRole role;

    public RegisterControllerResponse( String message, UserRole role) {
        this.message = message;
        this.role = role;
    }

    public static RegisterControllerResponse toResponse(RegisterResponseDto applicationDto) {
        return new RegisterControllerResponse(applicationDto.getMessage(), applicationDto.getRole());
    }
}
