package com.example.clean_architecture.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.clean_architecture.domain.model.user.User;
import com.example.clean_architecture.domain.model.user.UserId;
import com.example.clean_architecture.domain.repository.UserRepository;
import com.example.clean_architecture.infrastructure.persistence.entity.UserJpaEntity;
import com.example.clean_architecture.infrastructure.persistence.mapper.UserPersistenceMapper;
import com.example.clean_architecture.infrastructure.persistence.repository.SpringDataUserRepository;

@Repository 
public class UserRepositoryAdapter implements UserRepository {
    private final SpringDataUserRepository springDataUserRepository;
    private UserPersistenceMapper mapper;

    public UserRepositoryAdapter(SpringDataUserRepository springDataUserRepository, UserPersistenceMapper mapper) {
        this.springDataUserRepository = springDataUserRepository;
        this.mapper = mapper;
    }

    @Override
    public User save(User u) {
        UserJpaEntity userEntity = mapper.toJpaEntity(u);
        User userDomain = mapper.toDomain(springDataUserRepository.save(userEntity));
        return userDomain;
    }

    @Override
    public Optional<User> findUserById(UserId id) {
        Optional<UserJpaEntity> userJpaEntity = springDataUserRepository.findById(id.getId());
        return userJpaEntity.map(mapper::toDomain);
    }
}
