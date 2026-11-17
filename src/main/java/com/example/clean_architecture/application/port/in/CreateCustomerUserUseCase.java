package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.RegisterCustomerCommand;
import com.example.clean_architecture.application.dto.RegisterResponseDto;

public interface CreateCustomerUserUseCase {
    RegisterResponseDto register(RegisterCustomerCommand request);
}
