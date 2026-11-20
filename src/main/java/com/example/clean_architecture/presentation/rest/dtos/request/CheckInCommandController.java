package com.example.clean_architecture.presentation.rest.dtos.request;

import java.util.UUID;

import com.example.clean_architecture.application.dto.request.CheckInCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Setter 
@Getter 
public class CheckInCommandController {
    private UUID roomId;
    private UUID userId;

    public CheckInCommand toCommand() {
        CheckInCommand command = new CheckInCommand(roomId, userId);
        return command;
    }
}
