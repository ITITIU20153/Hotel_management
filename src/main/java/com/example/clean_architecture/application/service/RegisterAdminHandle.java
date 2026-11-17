package com.example.clean_architecture.application.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clean_architecture.application.dto.RegisterAdminCommand;
import com.example.clean_architecture.application.dto.RegisterResponseDto;
import com.example.clean_architecture.application.port.in.CreateAdminUserUseCase;
import com.example.clean_architecture.domain.model.user.Password;
import com.example.clean_architecture.domain.model.user.User;
import com.example.clean_architecture.domain.model.user.Username;
import com.example.clean_architecture.domain.repository.UserRepository;


@Service 
public class RegisterAdminHandle implements CreateAdminUserUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public RegisterAdminHandle(PasswordEncoder passwordEncoder,UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional 
    public RegisterResponseDto register(RegisterAdminCommand request) {
        String rawPassword = request.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        User user = User.createAdminUser(
            new Username(request.getUsername()), 
            new Password(encodedPassword));
        
        userRepository.save(user);

        return new RegisterResponseDto(
            "Register Admin Successfully",
            user.getRole()
        );
    }
}
