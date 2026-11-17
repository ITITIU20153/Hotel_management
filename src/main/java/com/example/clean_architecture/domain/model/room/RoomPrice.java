package com.example.clean_architecture.domain.model.room;

import java.math.BigDecimal;
import java.util.Objects;

public record RoomPrice(BigDecimal price) {
    public  RoomPrice {
        Objects.requireNonNull(price, "price must not be null");

        if (price.compareTo(BigDecimal.ZERO) <= 0) 
            throw new IllegalArgumentException("price must be more than zero");
    }

    public BigDecimal getPrice() {
        return price;
    }
}
