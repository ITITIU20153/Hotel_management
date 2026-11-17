package com.example.clean_architecture.domain.repository;

import com.example.clean_architecture.domain.model.user.User;

public interface UserRepository {
    User save(User u);
}
