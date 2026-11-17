package com.example.clean_architecture.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public enum ErrorCodeEnums {
    ROOM_NOT_AVAILABLE(
        "ROOM_NOT_AVAILABLE",
        "room is not available",
        HttpStatus.CONFLICT
    );

    private final String code;
    private final String message;
    private final HttpStatus status;
}