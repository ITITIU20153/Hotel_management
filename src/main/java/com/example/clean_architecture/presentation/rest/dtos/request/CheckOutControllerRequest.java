package com.example.clean_architecture.presentation.rest.dtos.request;

import java.util.UUID;

import com.example.clean_architecture.application.dto.request.CheckOutCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor
public class CheckOutControllerRequest {
    private UUID bookingId;    

    public CheckOutCommand toCommand() {
        return new CheckOutCommand(bookingId);
    }
}
