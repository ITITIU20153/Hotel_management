package com.example.clean_architecture.domain.repository;

import java.util.Optional;

import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.model.room.RoomId;

public interface RoomRepository {
    Optional<Room> findById(RoomId id);
    void save(Room room);
}