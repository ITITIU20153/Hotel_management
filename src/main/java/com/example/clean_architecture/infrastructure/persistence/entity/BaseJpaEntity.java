package com.example.clean_architecture.infrastructure.persistence.entity;

import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass 
@Getter 
@Setter 
public class BaseJpaEntity {
    @Id 
    private UUID id;
}
