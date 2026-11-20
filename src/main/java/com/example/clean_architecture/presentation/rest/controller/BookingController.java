package com.example.clean_architecture.presentation.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clean_architecture.application.dto.response.CheckInResponseDto;
import com.example.clean_architecture.application.port.in.CheckInRoomUseCase;
import com.example.clean_architecture.presentation.rest.dtos.request.CheckInCommandController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("booking")
@AllArgsConstructor 
public class BookingController {
    private final CheckInRoomUseCase checkInRoomUseCase;
    
    @PostMapping("/checkin")
    public CheckInResponseDto checkIn(@RequestBody CheckInCommandController request) {
        CheckInResponseDto response = checkInRoomUseCase.execute(request.toCommand());
        return response;
    }
}
