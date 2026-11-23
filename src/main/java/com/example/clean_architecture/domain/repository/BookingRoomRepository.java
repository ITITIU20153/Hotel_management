package com.example.clean_architecture.domain.repository;

import java.util.Optional;

import com.example.clean_architecture.domain.model.booking.BookingId;
import com.example.clean_architecture.domain.model.booking.BookingRoom;

public interface BookingRoomRepository {
    BookingRoom save(BookingRoom bookingRoom);

    Optional<BookingRoom> findBookingById(BookingId id);
}
