package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.request.CheckInCommand;
import com.example.clean_architecture.application.dto.response.CheckInResponseDto;

public interface CheckInRoomUseCase {
    CheckInResponseDto execute(CheckInCommand request); 
} 