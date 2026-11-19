package com.example.clean_architecture.domain.model.booking;

import java.time.Instant;

public record CheckOutDate(Instant date) {
    public CheckOutDate {
    }

    public static CheckOutDate execute() {
        return new CheckOutDate(Instant.now());
    }

} 
