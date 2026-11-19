package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.request.RegisterCustomerCommand;
import com.example.clean_architecture.application.dto.request.RegisterResponseDto;

public interface CreateCustomerUserUseCase {
    RegisterResponseDto register(RegisterCustomerCommand request);
}
