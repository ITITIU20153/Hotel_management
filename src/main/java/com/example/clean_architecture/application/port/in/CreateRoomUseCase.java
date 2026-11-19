package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.request.CreateRoomCommand;
import com.example.clean_architecture.application.dto.response.RoomResponseDto;

public interface CreateRoomUseCase {
    RoomResponseDto execute(CreateRoomCommand command);
}