package com.example.clean_architecture.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clean_architecture.application.dto.CreateRoomCommand;
import com.example.clean_architecture.application.dto.RoomResponseDto;
import com.example.clean_architecture.application.port.in.CreateRoomUseCase;
import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.repository.RoomRepository;

@Service 
public class CreateRoomCommandHandle implements CreateRoomUseCase {
    private final RoomRepository roomRepository;

    public CreateRoomCommandHandle(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override 
    @Transactional
    public RoomResponseDto execute(CreateRoomCommand command) {
        // Khởi tạo Domain Model
        Room room = Room.create(command.getRoomNumber(),command.getPrice());

        // Lưu qua Repository Interface
        roomRepository.save(room);
        RoomResponseDto response = new RoomResponseDto();
        return response.from(room);
    }
}