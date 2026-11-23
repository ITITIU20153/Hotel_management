package com.example.clean_architecture.application.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.example.clean_architecture.application.dto.request.CheckOutCommand;
import com.example.clean_architecture.application.dto.response.CheckOutResponseDto;
import com.example.clean_architecture.application.port.in.CheckOutRoomUseCase;
import com.example.clean_architecture.application.port.in.FindRoomByIdUseCase;
import com.example.clean_architecture.application.port.in.FindUserByIdUseCase;
import com.example.clean_architecture.domain.model.booking.BookingId;
import com.example.clean_architecture.domain.model.booking.BookingRoom;
import com.example.clean_architecture.domain.model.booking.CheckOutDate;
import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.model.user.User;
import com.example.clean_architecture.domain.repository.BookingRoomRepository;
import com.example.clean_architecture.domain.repository.RoomRepository;
import com.example.clean_architecture.domain.repository.UserRepository;
import com.example.clean_architecture.infrastructure.persistence.enums.ErrorCodeEnum;
import com.example.clean_architecture.presentation.rest.exception.NotFoundException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional 
@AllArgsConstructor 
public class CheckOutRoomHandle implements CheckOutRoomUseCase {

    private final BookingRoomRepository bookingRoomRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Override
    public CheckOutResponseDto execute(CheckOutCommand request) {
        BookingRoom bookingRoom = bookingRoomRepository.findBookingById(new BookingId(request.getBookingId())).
            orElseThrow(() -> new NotFoundException(ErrorCodeEnum.BOOKING_NOT_FOUND));
        User user = userRepository.findUserById(bookingRoom.getUserId()).
            orElseThrow(() -> new NotFoundException(ErrorCodeEnum.USER_NOT_FOUND));
        
        Room room = roomRepository.findById(bookingRoom.getRoomId()). 
            orElseThrow(() -> new NotFoundException(ErrorCodeEnum.ROOM_NOT_FOUND));

        bookingRoom.checkOut();

        bookingRoomRepository.save(bookingRoom);

        CheckOutResponseDto responseDto = new CheckOutResponseDto("Check out successfully", 
        user.getUsername().value(), room.getRoomNumber().number());
        return responseDto;
    }
    
}
