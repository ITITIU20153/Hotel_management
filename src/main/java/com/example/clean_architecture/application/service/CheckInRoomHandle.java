package com.example.clean_architecture.application.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.clean_architecture.application.dto.request.CheckInCommand;
import com.example.clean_architecture.application.dto.response.CheckInResponseDto;
import com.example.clean_architecture.application.dto.response.RoomResponseDto;
import com.example.clean_architecture.application.dto.response.UserResponseDto;
import com.example.clean_architecture.application.port.in.CheckInRoomUseCase;
import com.example.clean_architecture.application.port.in.FindRoomByIdUseCase;
import com.example.clean_architecture.application.port.in.FindUserByIdUseCase;
import com.example.clean_architecture.domain.model.booking.BookingRoom;
import com.example.clean_architecture.domain.model.room.RoomId;
import com.example.clean_architecture.domain.model.user.UserId;
import com.example.clean_architecture.domain.repository.BookingRoomRepository;
import com.example.clean_architecture.domain.repository.RoomRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
@Transactional 
public class CheckInRoomHandle implements CheckInRoomUseCase {

    private final BookingRoomRepository bookingRoomRepository;
    private  final FindRoomByIdUseCase findRoomByIdUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;

    @Override
    public CheckInResponseDto execute(CheckInCommand request) {
        RoomResponseDto roomResponseDto = findRoomByIdUseCase.findRoomById(new RoomId(request.getRoomId()));
        UserResponseDto userResponseDto = findUserByIdUseCase.findUserById(new UserId(request.getUserId()));
        BookingRoom checkIn = BookingRoom.checkIn(new UserId(request.getUserId()),new RoomId(request.getRoomId()));
        bookingRoomRepository.save(checkIn);
        CheckInResponseDto responseDto = new CheckInResponseDto(
            "Check In Room "+roomResponseDto.getRoomNumber()+ "Successfully ", 
            userResponseDto.getUsername(), roomResponseDto.getRoomNumber());
        return responseDto;
    }
}
