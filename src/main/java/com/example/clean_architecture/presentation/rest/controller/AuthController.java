package com.example.clean_architecture.presentation.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clean_architecture.application.dto.request.RegisterResponseDto;
import com.example.clean_architecture.application.port.in.CreateAdminUserUseCase;
import com.example.clean_architecture.application.port.in.CreateCustomerUserUseCase;
import com.example.clean_architecture.application.port.in.CreateStaffUserUseCase;
import com.example.clean_architecture.presentation.rest.dtos.request.CreateAdminRequestDto;
import com.example.clean_architecture.presentation.rest.dtos.request.CreateCustomerRequestDto;
import com.example.clean_architecture.presentation.rest.dtos.request.CreateStaffRequestDto;
import com.example.clean_architecture.presentation.rest.dtos.response.RegisterControllerResponse;

@RestController 
@RequestMapping("/auth")
public class AuthController {
    private final CreateAdminUserUseCase createAdminUserUseCase;
    private final CreateStaffUserUseCase createStaffUserUseCase;
    private final CreateCustomerUserUseCase createCustomerUserUseCase;
    
    public AuthController(CreateAdminUserUseCase createAdminUserUseCase, CreateStaffUserUseCase createStaffUserUseCase,
            CreateCustomerUserUseCase createCustomerUserUseCase) {
        this.createAdminUserUseCase = createAdminUserUseCase;
        this.createStaffUserUseCase = createStaffUserUseCase;
        this.createCustomerUserUseCase = createCustomerUserUseCase;
    }
    
    @PostMapping("/admin")
    public RegisterControllerResponse registerAdmin(@RequestBody CreateAdminRequestDto request) {
        RegisterResponseDto response = createAdminUserUseCase.register(request.toCommand());
        return RegisterControllerResponse.toResponse(response);
    }

    @PostMapping("/staff")
    public RegisterControllerResponse registerStaff(@RequestBody CreateStaffRequestDto request) {
        RegisterResponseDto response = createStaffUserUseCase.register(request.toCommand());
        return RegisterControllerResponse.toResponse(response);
    }
    
    @PostMapping("/customer")
    public RegisterControllerResponse registerCustomer(@RequestBody CreateCustomerRequestDto request) {
        RegisterResponseDto response = createCustomerUserUseCase.register(request.toCommand());
        return RegisterControllerResponse.toResponse(response);
    }
}
