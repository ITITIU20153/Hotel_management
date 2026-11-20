package com.example.clean_architecture.domain.repository;

import com.example.clean_architecture.domain.model.booking.BookingRoom;

public interface BookingRoomRepository {
    BookingRoom save(BookingRoom bookingRoom);
}
