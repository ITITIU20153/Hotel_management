package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.RegisterAdminCommand;
import com.example.clean_architecture.application.dto.RegisterResponseDto;

public interface CreateAdminUserUseCase {
    RegisterResponseDto register(RegisterAdminCommand request);
}
