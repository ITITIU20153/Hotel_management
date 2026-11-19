package com.example.clean_architecture.domain.model.booking;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
 
public record RoomId(UUID id,BigDecimal price) {
    public  RoomId {
        Objects.requireNonNull(id,"RoomId requires not null");
        Objects.requireNonNull(price,"price requires not null");
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("price must be larger than 0");
        }
    } 
}
