package com.example.clean_architecture.infrastructure.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clean_architecture.infrastructure.persistence.entity.RoomJpaEntity;

public interface SpringDataRoomRepository extends JpaRepository<RoomJpaEntity,UUID> {
    
}
