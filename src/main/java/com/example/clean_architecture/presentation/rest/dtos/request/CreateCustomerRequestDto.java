package com.example.clean_architecture.presentation.rest.dtos.request;

import com.example.clean_architecture.application.dto.request.RegisterCustomerCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
public class CreateCustomerRequestDto {
    private String username;
    private String password;

    public RegisterCustomerCommand toCommand() {
        return new  RegisterCustomerCommand(
            username,
            password
        );
    }
}
