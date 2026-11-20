package com.example.clean_architecture.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.example.clean_architecture.domain.model.user.User;
import com.example.clean_architecture.domain.model.user.UserId;

public interface UserRepository {
    User save(User u);

    Optional<User> findUserById(UserId id);
}
