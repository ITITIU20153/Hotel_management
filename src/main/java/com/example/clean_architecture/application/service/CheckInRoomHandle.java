package com.example.clean_architecture.application.service;

import org.springframework.stereotype.Service;

import com.example.clean_architecture.application.dto.request.CheckInCommand;
import com.example.clean_architecture.application.dto.response.CheckInResponseDto;
import com.example.clean_architecture.application.port.in.CheckInRoomUseCase;

@Service 
public class CheckInRoomHandle implements CheckInRoomUseCase {

    private final 
    @Override
    public CheckInResponseDto execute(CheckInCommand request) {
        
        
    }
    
}
