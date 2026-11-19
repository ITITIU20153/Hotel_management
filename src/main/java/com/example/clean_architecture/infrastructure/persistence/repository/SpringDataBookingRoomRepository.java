package com.example.clean_architecture.infrastructure.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clean_architecture.infrastructure.persistence.entity.BookingRoomJpaEntity;

public interface SpringDataBookingRoomRepository extends JpaRepository<BookingRoomJpaEntity,UUID> {
    
}
