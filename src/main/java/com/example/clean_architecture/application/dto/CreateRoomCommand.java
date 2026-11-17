package com.example.clean_architecture.application.dto;

import com.example.clean_architecture.domain.model.room.RoomNumber;
import com.example.clean_architecture.domain.model.room.RoomPrice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor 
@Getter 
@Setter 
public class CreateRoomCommand {
    private RoomNumber roomNumber;
    private RoomPrice price;

}
