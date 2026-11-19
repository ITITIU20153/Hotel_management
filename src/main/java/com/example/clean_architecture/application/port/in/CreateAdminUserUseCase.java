package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.request.RegisterAdminCommand;
import com.example.clean_architecture.application.dto.request.RegisterResponseDto;

public interface CreateAdminUserUseCase {
    RegisterResponseDto register(RegisterAdminCommand request);
}
