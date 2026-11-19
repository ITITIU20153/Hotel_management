package com.example.clean_architecture.infrastructure.persistence.entity;

import com.example.clean_architecture.domain.model.user.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "user_table")
@Getter 
@Setter 
public class UserJpaEntity extends BaseJpaEntity {
    // @Column(unique = true,nullable = false)
    private String username;
    // @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
