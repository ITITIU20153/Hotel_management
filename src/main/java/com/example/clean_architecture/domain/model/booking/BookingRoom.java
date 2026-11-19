package com.example.clean_architecture.domain.model.booking;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import lombok.Getter;

@Getter 
public class BookingRoom {
    private final BookingId id;
    private CustomerId customerId;
    private RoomId roomId;
    private CheckInDate checkInDate;
    private CheckOutDate checkOutDate;
    private BookingStatus status;
    
    private BookingRoom(BookingId id, CustomerId customerId, RoomId roomId, CheckInDate checkInDate,
            CheckOutDate checkOutDate,
         BookingStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    public static BookingRoom checkIn(CustomerId customerId,RoomId roomId) {
        return new BookingRoom(BookingId.generate(), 
        customerId, roomId,
        CheckInDate.execute(),
        null,
        BookingStatus.CHECK_IN);
    }

    public void checkOut(CheckOutDate checkOutDate) {
        if (this.status != BookingStatus.CHECK_IN) {
            throw new IllegalStateException("Only CHECKED_IN booking can check out");
        }
        this.checkOutDate = checkOutDate;
        this.status = BookingStatus.CHECK_OUT;
    }

    public BigDecimal calculateFinalAmount(RoomId room) {
        if (this.checkOutDate == null) {
            throw new IllegalStateException("Cannot calculate final amount before check-out");
        }
        long days = ChronoUnit.DAYS.between(this.checkInDate.createAt(), this.checkOutDate.date());
        BigDecimal price  = room.price();
        return price.multiply(BigDecimal.valueOf(days)); 
    }

    public static BookingRoom reconstitute(BookingId id, 
        CustomerId customerId, 
        RoomId roomId, 
        CheckInDate checkInDate,
        CheckOutDate checkOutDate,
        BookingStatus status) {
            return new BookingRoom(id, customerId, roomId, checkInDate, checkOutDate, status);
        }
}
