package com.example.clean_architecture.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.model.room.RoomStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class RoomResponseDto {
    private UUID roomId;
    private String roomNumber;
    private BigDecimal roomPrice;
    private RoomStatus status;

    public RoomResponseDto from(Room room) {
        return new RoomResponseDto(room.getRoomId().value(), 
        room.getRoomNumber().getRoomNumber(), 
        room.getRoomPrice().getPrice(), 
        room.getStatus());
    }
}
