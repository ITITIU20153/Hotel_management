package com.example.clean_architecture.application.service;

import org.springframework.stereotype.Service;

import com.example.clean_architecture.application.dto.response.UserResponseDto;
import com.example.clean_architecture.application.port.in.FindUserByIdUseCase;
import com.example.clean_architecture.domain.model.user.User;
import com.example.clean_architecture.domain.model.user.UserId;
import com.example.clean_architecture.domain.repository.UserRepository;
import com.example.clean_architecture.infrastructure.persistence.enums.ErrorCodeEnum;
import com.example.clean_architecture.presentation.rest.exception.NotFoundException;

@Service 
public class FindUserByIdHandle implements FindUserByIdUseCase {

    private final UserRepository userRepository;
    public FindUserByIdHandle(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto findUserById(UserId id) {
        User user = userRepository.findUserById(id).
            orElseThrow(() -> new NotFoundException(ErrorCodeEnum.USER_NOT_FOUND));
        UserResponseDto response = new UserResponseDto(user.getUsername().value(), user.getRole());
        return response;
    }
    
}
