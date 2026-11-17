package com.example.clean_architecture.domain.model.user;

import java.util.Objects;
import java.util.UUID;

public record UserId(UUID id) {
    public UserId {
        Objects.requireNonNull(id, "UserId requires not null");
    }

    public static UserId fromString(String rawValue) {
        Objects.requireNonNull(rawValue, "UserId String requires not null");
        try {
            return new UserId(UUID.fromString(rawValue));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("UserId string not suitable: " + rawValue, e);
        }
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }
    
    @Override 
    public String toString() {
        return id.toString();
    }
}
