package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.CreateRoomCommand;
import com.example.clean_architecture.application.dto.RoomResponseDto;

public interface CreateRoomUseCase {
    RoomResponseDto execute(CreateRoomCommand command);
}
