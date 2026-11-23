package com.example.clean_architecture.domain.model.booking;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.example.clean_architecture.domain.model.room.RoomId;
import com.example.clean_architecture.domain.model.user.UserId;

import lombok.Data;
import lombok.Getter;

@Getter 
@Data 
public class BookingRoom {
    private final BookingId id;
    private UserId userId;
    private RoomId roomId;
    private CheckInDate checkInDate;
    private CheckOutDate checkOutDate;
    private BookingStatus status;
    
    private BookingRoom(
        BookingId id, 
        UserId userId, 
        RoomId roomId, 
        CheckInDate checkInDate,
        CheckOutDate checkOutDate,
        BookingStatus status
    ) 
    {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    public static BookingRoom checkIn(UserId UserId,RoomId roomId) {
        return new BookingRoom(BookingId.generate(), 
        UserId, roomId,
        CheckInDate.execute(),
        new CheckOutDate(null),
        BookingStatus.CHECK_IN);
    }

    public void checkOut() {
        if (status != BookingStatus.CHECK_IN ) {
            throw new IllegalStateException("Only CHECKED_IN booking can check out");
        }
        this.checkOutDate = new CheckOutDate(Instant.now());
        this.status = BookingStatus.CHECK_OUT;
    }

    public static BookingRoom reconstitute(BookingId id, 
        UserId UserId, 
        RoomId roomId, 
        CheckInDate checkInDate,
        CheckOutDate checkOutDate,
        BookingStatus status) {
            return new BookingRoom(id, UserId, roomId, checkInDate, checkOutDate, status);
        }
}
