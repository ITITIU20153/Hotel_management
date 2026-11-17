package com.example.clean_architecture.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.example.clean_architecture.domain.model.user.Password;
import com.example.clean_architecture.domain.model.user.User;
import com.example.clean_architecture.domain.model.user.UserId;
import com.example.clean_architecture.domain.model.user.Username;
import com.example.clean_architecture.infrastructure.persistence.entity.UserJpaEntity;

@Component 
public class UserPersistenceMapper {
    public UserJpaEntity toJpaEntity(User domain) {
        UserJpaEntity UserJpaEntity = new UserJpaEntity();
        UserJpaEntity.setId(domain.getId().getId());
        UserJpaEntity.setUsername(domain.getUsername().value());
        UserJpaEntity.setPassword(domain.getPassword().value());
        UserJpaEntity.setRole(domain.getRole());
        return UserJpaEntity;
    }

    public User toDomain(UserJpaEntity entity) {
        return User.reconstitute(
            new UserId(entity.getId()),
            new Username(entity.getUsername()), 
            new Password(entity.getPassword()), 
            entity.getRole()
        );
    }
}
