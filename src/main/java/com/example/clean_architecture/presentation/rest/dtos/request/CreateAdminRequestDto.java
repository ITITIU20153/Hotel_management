package com.example.clean_architecture.presentation.rest.dtos.request;

import com.example.clean_architecture.application.dto.request.RegisterAdminCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
public class CreateAdminRequestDto {
    private String username;
    private String password;

    public RegisterAdminCommand toCommand() {
        return new  RegisterAdminCommand(
            username,
            password
        );
    }
}
