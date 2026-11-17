package com.example.clean_architecture.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.model.room.RoomId;
import com.example.clean_architecture.domain.model.room.RoomNumber;
import com.example.clean_architecture.domain.model.room.RoomPrice;
import com.example.clean_architecture.infrastructure.persistence.entity.RoomJpaEntity;

@Component 
public class RoomPersistenceMapper {
    public RoomJpaEntity toJpaEntity(Room domain) {
        RoomJpaEntity roomJpaEntity = new RoomJpaEntity();
        roomJpaEntity.setId(domain.getRoomId().value());
        roomJpaEntity.setPrice(domain.getRoomPrice().price());
        roomJpaEntity.setRoomNumber(domain.getRoomNumber().number());
        roomJpaEntity.setStatus(domain.getStatus());
        return roomJpaEntity;
    }

    public Room toDomain(RoomJpaEntity entity) {
        return Room.reconstitute(
            new RoomId(entity.getId()), 
            new RoomNumber(entity.getRoomNumber()), 
            new RoomPrice(entity.getPrice()), 
            entity.getStatus());
    }
}
