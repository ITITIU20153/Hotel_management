package com.example.clean_architecture.domain.model.booking;

import java.util.Objects;
import java.util.UUID;

public record BookingId(UUID id) {
    public BookingId {
        Objects.requireNonNull(id, "BookingId requires not null");
    }

    public static BookingId fromString(String rawValue) {
        Objects.requireNonNull(rawValue, "BookingId String requires not null");
        try {
            return new BookingId(UUID.fromString(rawValue));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("BookingId string not suitable: " + rawValue, e);
        }
    }

    public static BookingId generate() {
        return new BookingId(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }
    
    @Override 
    public String toString() {
        return id.toString();
    }
}
