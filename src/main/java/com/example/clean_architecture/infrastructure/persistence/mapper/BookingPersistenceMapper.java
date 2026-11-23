package com.example.clean_architecture.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.example.clean_architecture.domain.model.booking.BookingId;
import com.example.clean_architecture.domain.model.booking.BookingRoom;
import com.example.clean_architecture.domain.model.booking.CheckInDate;
import com.example.clean_architecture.domain.model.booking.CheckOutDate;
import com.example.clean_architecture.domain.model.room.RoomId;
import com.example.clean_architecture.domain.model.user.UserId;
import com.example.clean_architecture.infrastructure.persistence.entity.BookingRoomJpaEntity;

@Component 
public class BookingPersistenceMapper {
     public BookingRoomJpaEntity toEntity(BookingRoom domain) {
      BookingRoomJpaEntity entity =  new BookingRoomJpaEntity();
      entity.setId(domain.getId().getId());
      entity.setRoomId(domain.getRoomId().value());
      entity.setUserId(domain.getUserId().getId());
      entity.setStatus(domain.getStatus());
      entity.setCheckInDate(domain.getCheckInDate().createAt());
      entity.setCheckOutDate(domain.getCheckOutDate().date());
      return entity;
     }

     public BookingRoom toDomain(BookingRoomJpaEntity entity) {
     return BookingRoom.reconstitute(
     new BookingId(entity.getId()),
     new UserId(entity.getUserId()), 
     new RoomId(entity.getRoomId()), 
     new CheckInDate(entity.getCheckInDate()), 
     new CheckOutDate(entity.getCheckOutDate()), 
      entity.getStatus());
     }
}
