package com.example.clean_architecture.presentation.rest.dtos.request;

import java.math.BigDecimal;

import com.example.clean_architecture.application.dto.request.CreateRoomCommand;
import com.example.clean_architecture.domain.model.room.RoomNumber;
import com.example.clean_architecture.domain.model.room.RoomPrice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Getter 
@Setter 
public class CreateRoomRequestDto {
    private String roomNumber;
    private BigDecimal price;

    public CreateRoomCommand toCommand() {
        RoomNumber roomNum = new RoomNumber(roomNumber);
        RoomPrice roomPrice = new RoomPrice(price);
        return new CreateRoomCommand(roomNum,roomPrice);
    }
}
