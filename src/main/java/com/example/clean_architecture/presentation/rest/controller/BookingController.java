package com.example.clean_architecture.presentation.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clean_architecture.application.dto.request.CheckOutCommand;
import com.example.clean_architecture.application.dto.response.CheckInResponseDto;
import com.example.clean_architecture.application.dto.response.CheckOutResponseDto;
import com.example.clean_architecture.application.port.in.CheckInRoomUseCase;
import com.example.clean_architecture.application.port.in.CheckOutRoomUseCase;
import com.example.clean_architecture.presentation.rest.dtos.request.CheckInCommandController;
import com.example.clean_architecture.presentation.rest.dtos.request.CheckOutControllerRequest;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("booking")
@AllArgsConstructor 
public class BookingController {
    private final CheckInRoomUseCase checkInRoomUseCase;
    private final CheckOutRoomUseCase checkOutRoomUseCase;
    
    @PostMapping("/checkin")
    public CheckInResponseDto checkIn(@RequestBody CheckInCommandController request) {
        CheckInResponseDto response = checkInRoomUseCase.execute(request.toCommand());
        return response;
    }

    @PostMapping("/checkout")
    public CheckOutResponseDto checkOut(@RequestBody CheckOutControllerRequest request) {
        CheckOutCommand command = request.toCommand();     
        CheckOutResponseDto response = checkOutRoomUseCase.execute(command);   
        return response;
    }
    
}
