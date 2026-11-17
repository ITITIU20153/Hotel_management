package com.example.clean_architecture.presentation.rest.dtos.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.clean_architecture.application.dto.RoomResponseDto;
import com.example.clean_architecture.domain.model.room.RoomStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class RoomControllerResponse {
     private UUID roomId;
    private String roomNumber;
    private BigDecimal roomPrice;
    private RoomStatus status;

    public static RoomControllerResponse toReponse(RoomResponseDto response) {
        return new RoomControllerResponse(response.getRoomId(), 
        response.getRoomNumber(), 
        response.getRoomPrice(), 
      response.getStatus());
    }
}
