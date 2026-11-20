package com.example.clean_architecture.application.port.in;

import com.example.clean_architecture.application.dto.response.UserResponseDto;
import com.example.clean_architecture.domain.model.user.UserId;

public interface FindUserByIdUseCase {
    UserResponseDto findUserById(UserId id);
}
