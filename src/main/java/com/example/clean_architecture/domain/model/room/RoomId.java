package com.example.clean_architecture.domain.model.room;

import java.util.Objects;
import java.util.UUID;

/**
 * RoomId
 */
public record RoomId(UUID value) {
    public RoomId {
        Objects.requireNonNull(value, "RoomId requires not null");
    }

    public static RoomId generate() {
        return new RoomId(UUID.randomUUID());
    }

    // Factory method: Chuyển đổi từ String (ví dụ từ API hoặc DB)
    public static RoomId fromString(String rawValue) {
        Objects.requireNonNull(rawValue, "RoomId String requires not null");
        try {
            return new RoomId(UUID.fromString(rawValue));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("RoomId string not suitable: " + rawValue, e);
        }
    }

    
    @Override
    public String toString() {
        return value.toString();
    }
}