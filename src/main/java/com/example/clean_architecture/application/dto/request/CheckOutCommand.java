package com.example.clean_architecture.application.dto.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Setter 
@Getter 
public class CheckOutCommand {
    private UUID bookingId;
}
