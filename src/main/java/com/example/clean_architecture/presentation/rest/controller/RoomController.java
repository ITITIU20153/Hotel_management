package com.example.clean_architecture.presentation.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clean_architecture.application.service.CreateRoomCommandHandle;
import com.example.clean_architecture.presentation.rest.dtos.request.CreateRoomRequestDto;
import com.example.clean_architecture.presentation.rest.dtos.response.RoomControllerResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/rooms")
public class RoomController {
    private final CreateRoomCommandHandle createRoomUseCase;

    public RoomController(CreateRoomCommandHandle createRoomUseCase) {
        this.createRoomUseCase = createRoomUseCase;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testAPI() {
        return ResponseEntity.ok("Room API is success");
    }

    @PostMapping()
    public ResponseEntity<RoomControllerResponse> postRoom(@RequestBody CreateRoomRequestDto request) {        
        RoomControllerResponse response = RoomControllerResponse.toReponse(createRoomUseCase.execute(request.toCommand())); 
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
