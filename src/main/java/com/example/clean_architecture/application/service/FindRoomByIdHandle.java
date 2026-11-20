package com.example.clean_architecture.application.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.clean_architecture.application.dto.response.RoomResponseDto;
import com.example.clean_architecture.application.port.in.FindRoomByIdUseCase;
import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.model.room.RoomId;
import com.example.clean_architecture.domain.repository.RoomRepository;
import com.example.clean_architecture.infrastructure.persistence.enums.ErrorCodeEnum;
import com.example.clean_architecture.presentation.rest.exception.NotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor 
@Service 
public class FindRoomByIdHandle implements FindRoomByIdUseCase {

    private final RoomRepository roomRepository ;

    @Override
    public RoomResponseDto findRoomById(RoomId id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCodeEnum.ROOM_NOT_FOUND));
        RoomResponseDto responseDto =  new RoomResponseDto();
        responseDto.setRoomId(room.getRoomId().value());
        responseDto.setRoomNumber(room.getRoomNumber().getRoomNumber());
        responseDto.setRoomPrice(room.getRoomPrice().price());
        responseDto.setStatus(room.getStatus());
        return responseDto;
    }
    

}
