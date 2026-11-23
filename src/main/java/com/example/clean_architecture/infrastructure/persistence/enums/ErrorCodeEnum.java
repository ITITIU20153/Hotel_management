package com.example.clean_architecture.infrastructure.persistence.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCodeEnum {

    ROOM_NOT_FOUND(
        "ROOM_NOT_FOUND",
        "Room not found",
        HttpStatus.NOT_FOUND
    ),
    USER_NOT_FOUND(
        "USER_NOT_FOUND",
        "User not found",
        HttpStatus.NOT_FOUND
    ),
    BOOKING_NOT_FOUND(
        "BOOKING_NOT_FOUND",
        "Booking not found",
        HttpStatus.NOT_FOUND
    );

    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCodeEnum(
            String code,
            String message,
            HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}