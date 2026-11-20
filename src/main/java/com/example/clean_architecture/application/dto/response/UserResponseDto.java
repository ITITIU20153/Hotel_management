package com.example.clean_architecture.application.dto.response;

import com.example.clean_architecture.domain.model.user.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Getter 
@Setter 
public class UserResponseDto {
    private String username;
    private UserRole role;
}
