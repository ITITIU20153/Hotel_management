package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.response.RoomResponseDto;
import com.example.clean_architecture.domain.model.room.RoomId;

public interface FindRoomByIdUseCase {
    RoomResponseDto findRoomById(RoomId id);
}