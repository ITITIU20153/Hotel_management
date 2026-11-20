package com.example.clean_architecture.infrastructure.persistence.entity;

import java.time.Instant;
import java.util.UUID;

import com.example.clean_architecture.domain.model.booking.BookingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Entity 
@Table(name = "booking_table")
public class BookingRoomJpaEntity extends BaseJpaEntity {
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "room_id")
    private UUID roomId;

    private Instant checkInDate;

    private Instant checkOutDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
