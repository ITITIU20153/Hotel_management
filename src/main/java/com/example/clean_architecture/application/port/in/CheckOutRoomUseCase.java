package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.request.CheckOutCommand;
import com.example.clean_architecture.application.dto.response.CheckOutResponseDto;

public interface CheckOutRoomUseCase {
    CheckOutResponseDto execute(CheckOutCommand command);
}