package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.request.RegisterResponseDto;
import com.example.clean_architecture.application.dto.request.RegisterStaffCommand;

public interface CreateStaffUserUseCase {
    RegisterResponseDto register(RegisterStaffCommand request);
}
