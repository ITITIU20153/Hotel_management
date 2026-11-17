package com.example.clean_architecture.domain.exception;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;

import lombok.Getter;

@Getter 
public class NotNullException extends RuntimeException {
    
    private DomainErrorCodeEnums errorCodeEnums;
    
    public NotNullException(DomainErrorCodeEnums errorCodeEnums) {
        super(errorCodeEnums.getMessage());
        this.errorCodeEnums = errorCodeEnums;
    }
}
