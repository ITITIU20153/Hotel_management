package com.example.clean_architecture.domain.model.booking;

import java.time.Instant;

public record CheckInDate(Instant createAt) {
    public CheckInDate {
    }

    public static CheckInDate execute() {
        return new CheckInDate(Instant.now());
    }

}
