package com.example.clean_architecture.domain.model.room;

import java.util.Objects;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;
import com.example.clean_architecture.domain.exception.DomainException;

public record RoomNumber(String number) {

     public RoomNumber {
        if (number == null || number.isBlank()) {
            throw new DomainException(
                DomainErrorCodeEnums.ROOM_NUMBER_NOT_NULL
            );
        }
    }

    public String getRoomNumber() {
        return number;
    }
}
