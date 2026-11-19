package com.example.clean_architecture.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
public class CheckInResponseDto {
    private String message;
    private String username;
    private String roomNumber;
}
