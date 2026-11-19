package com.example.clean_architecture.domain.repository;

import java.util.UUID;

import com.example.clean_architecture.domain.model.booking.BookingRoom;
import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.model.user.User;

public interface BookingRoomRepository {
    BookingRoom save(BookingRoom bookingRoom);
}
