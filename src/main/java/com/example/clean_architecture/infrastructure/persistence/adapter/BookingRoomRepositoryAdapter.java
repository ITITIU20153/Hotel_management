package com.example.clean_architecture.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.clean_architecture.domain.model.booking.BookingId;
import com.example.clean_architecture.domain.model.booking.BookingRoom;
import com.example.clean_architecture.domain.repository.BookingRoomRepository;
import com.example.clean_architecture.infrastructure.persistence.entity.BookingRoomJpaEntity;
import com.example.clean_architecture.infrastructure.persistence.mapper.BookingPersistenceMapper;
import com.example.clean_architecture.infrastructure.persistence.repository.SpringDataBookingRoomRepository;

@Repository 
public class BookingRoomRepositoryAdapter implements BookingRoomRepository {
    private final SpringDataBookingRoomRepository springDataBookingRoomRepository;
    private final BookingPersistenceMapper mapper;
    public BookingRoomRepositoryAdapter(SpringDataBookingRoomRepository springDataBookingRoomRepository,
            BookingPersistenceMapper mapper) {
        this.springDataBookingRoomRepository = springDataBookingRoomRepository;
        this.mapper = mapper;
    }

    @Override
    public BookingRoom save(BookingRoom bookingRoom) {
        BookingRoomJpaEntity entity = mapper.toEntity(bookingRoom);
        entity = springDataBookingRoomRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<BookingRoom> findBookingById(BookingId id) {
        Optional<BookingRoomJpaEntity> bookingRoom = springDataBookingRoomRepository.findById(id.getId());
        Optional<BookingRoom> bookingDomain = bookingRoom.map(mapper::toDomain);
        return bookingDomain;
    }
    
}
