package com.example.clean_architecture.application.port.in;

import java.util.UUID;

import com.example.clean_architecture.application.dto.response.RoomResponseDto;

public interface FindRoomByIdUseCase {
    RoomResponseDto findRoomById(UUID id);
}
