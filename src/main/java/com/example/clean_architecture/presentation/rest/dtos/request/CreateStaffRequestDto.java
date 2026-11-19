package com.example.clean_architecture.presentation.rest.dtos.request;

import com.example.clean_architecture.application.dto.request.RegisterStaffCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
public class CreateStaffRequestDto {
    private String username;
    private String password;

    public RegisterStaffCommand toCommand() {
        return new  RegisterStaffCommand(
            username,
            password
        );
    }
}
