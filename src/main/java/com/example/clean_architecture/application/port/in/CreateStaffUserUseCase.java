package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.RegisterResponseDto;
import com.example.clean_architecture.application.dto.RegisterStaffCommand;

public interface CreateStaffUserUseCase {
    RegisterResponseDto register(RegisterStaffCommand request);
}
