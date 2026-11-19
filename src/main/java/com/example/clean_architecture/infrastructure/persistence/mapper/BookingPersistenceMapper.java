package com.example.clean_architecture.infrastructure.persistence.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.clean_architecture.domain.model.booking.BookingId;
import com.example.clean_architecture.domain.model.booking.BookingRoom;
import com.example.clean_architecture.domain.model.booking.CheckInDate;
import com.example.clean_architecture.domain.model.booking.CheckOutDate;
import com.example.clean_architecture.domain.model.booking.CustomerId;
import com.example.clean_architecture.domain.model.booking.RoomId;
import com.example.clean_architecture.infrastructure.persistence.entity.BookingRoomJpaEntity;

@Component 
public class BookingPersistenceMapper {
     public BookingRoomJpaEntity toEntity(BookingRoom domain) {
      BookingRoomJpaEntity entity =  new BookingRoomJpaEntity();
      entity.setId(domain.getId().getId());
      entity.setRooms(domain.getRoomId().id());
      entity.setUser(domain.getCustomerId().id());
      entity.setStatus(domain.getStatus());
      entity.setCheckInDate(domain.getCheckInDate().createAt());
      entity.setCheckOutDate(domain.getCheckOutDate().date());
      return entity;
     }

     public BookingRoom toDomain(BookingRoomJpaEntity entity) {
      return BookingRoom.reconstitute(
      new BookingId(entity.getId()),
       new CustomerId(entity.getUser()), 
       new RoomId(entity.getId(), null), 
       new CheckInDate(entity.getCheckInDate()), 
       new CheckOutDate(entity.getCheckOutDate()), 
      entity.getStatus());
     }
}
