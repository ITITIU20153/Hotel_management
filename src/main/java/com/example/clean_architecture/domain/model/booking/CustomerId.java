package com.example.clean_architecture.domain.model.booking;

import java.util.Objects;
import java.util.UUID;

public record CustomerId(UUID id) {
    public CustomerId {
        Objects.requireNonNull(id,"Require Customer Id not null");

    }

    public static CustomerId of(UUID id) {
        return new CustomerId(id);
    }
}
