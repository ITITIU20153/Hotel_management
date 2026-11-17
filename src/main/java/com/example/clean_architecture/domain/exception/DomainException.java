package com.example.clean_architecture.domain.exception;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;

public class DomainException extends RuntimeException {
    private DomainErrorCodeEnums enumCode;
    public DomainErrorCodeEnums getEnumCode() {
        return enumCode;
    }
    public DomainException(DomainErrorCodeEnums enumCode) {
        super(enumCode.getMessage());
        this.enumCode = enumCode;
    }
} 
