package com.example.clean_architecture.domain.model.room;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;
import com.example.clean_architecture.domain.exception.DomainException;
import com.example.clean_architecture.domain.exception.RoomNotAvailableException;

import lombok.Getter;

@Getter 
public class Room  {
    private final RoomId roomId;
    private RoomNumber roomNumber;
    private RoomPrice roomPrice;
    private RoomStatus status;

    private Room(RoomId roomId,
        RoomNumber roomNumber,
        RoomPrice roomPrice,
        RoomStatus status) {
            this.roomId = roomId;
            this.roomNumber= roomNumber;
            this.roomPrice = roomPrice;
            this.status = status;
    }

    // public void book() {
    //     if (this.status == RoomStatus.MAINTENANCE) {
    //         throw new DomainException(DomainErrorCodeEnums.ROOM_MAINTAINING);
    //     } else if (this.status == RoomStatus.OCCUPIED) {
    //         throw new RoomNotAvailableException(DomainErrorCodeEnums.ROOM_MAINTAINING);
    //     }
    //     this.status = RoomStatus.OCCUPIED;
    // }

    // public void cancel() {
    //     if (this.status == RoomStatus.AVAILABLE) {
    //         throw new IllegalArgumentException("Room "+roomNumber+ " is already available. Cannot be canceled");
    //     }
    //     this.status = RoomStatus.AVAILABLE;
    // }

    public static Room create( RoomNumber roomNumber, RoomPrice roomPrice) {
        return new Room(RoomId.generate(), roomNumber, roomPrice, RoomStatus.AVAILABLE);
    }

    public static Room reconstitute(RoomId id, RoomNumber roomNumber, RoomPrice roomPrice, RoomStatus status) {
        return new Room(id, roomNumber, roomPrice, status);
    }

    
}