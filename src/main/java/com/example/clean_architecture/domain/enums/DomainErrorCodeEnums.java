package com.example.clean_architecture.domain.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public enum DomainErrorCodeEnums {
    ROOM_NUMBER_NOT_NULL(
        "ROOM_NUMBER_NOT_NULL",
        "room number must not null",
        HttpStatus.CONFLICT
    ),
    ROOM_PRICE_NOT_NULL(
        "ROOM_PRICE_NOT_NULL",
        "room price must not null",
        HttpStatus.CONFLICT
    ),
    ROOM_MAINTAINING(
        "ROOM_MAINTAINING",
        "room is maintaining",
        HttpStatus.CONFLICT
    ),
    USERNAME_NOT_NULL(
        "USERNAME_NOT_NULL",
        "Username must not be null",
        HttpStatus.BAD_REQUEST
    ),
    USERNAME_NOT_BLANK(
        "USERNAME_NOT_BLANK",
        "Username must not be blank",
        HttpStatus.BAD_REQUEST
    ),
    USERNAME_LENGTH(
        "USERNAME_LENGTH",
        "Username must be between 3 and 30 characters",
        HttpStatus.BAD_REQUEST
    ),
    USERNAME_INVALID(
        "USERNAME_INVALID",
        "Username contains invalid characters",
        HttpStatus.BAD_REQUEST
    ),
    PASSWORD_NOT_BLANK(
        "PASSWORD_NOT_BLANK",
        "Password must not be blank",
        HttpStatus.BAD_REQUEST
    );

    private final String code;
    private final String message;
    private final HttpStatus status;
}
