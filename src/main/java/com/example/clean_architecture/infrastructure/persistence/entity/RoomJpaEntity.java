package com.example.clean_architecture.infrastructure.persistence.entity;

import java.math.BigDecimal;
import com.example.clean_architecture.domain.model.room.RoomStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room_table")
@Getter
@Setter
public class RoomJpaEntity extends BaseJpaEntity {
    private String roomNumber;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    
}
