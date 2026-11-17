package com.example.clean_architecture.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.clean_architecture.domain.model.room.Room;
import com.example.clean_architecture.domain.model.room.RoomId;
import com.example.clean_architecture.domain.repository.RoomRepository;
import com.example.clean_architecture.infrastructure.persistence.mapper.RoomPersistenceMapper;
import com.example.clean_architecture.infrastructure.persistence.repository.SpringDataRoomRepository;

@Repository 
public class RoomRepositoryAdapter implements RoomRepository {
    private SpringDataRoomRepository springDataRoomRepository;
    private RoomPersistenceMapper mapper;

    public  RoomRepositoryAdapter(SpringDataRoomRepository springDataRoomRepository,RoomPersistenceMapper mapper) {
        this.springDataRoomRepository = springDataRoomRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Room> findById(RoomId id) {
        return  springDataRoomRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public void save(Room room) {
        springDataRoomRepository.save( mapper.toJpaEntity(room));
    }
    
}
