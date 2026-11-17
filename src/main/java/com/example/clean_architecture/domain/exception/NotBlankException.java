package com.example.clean_architecture.domain.exception;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;

import lombok.Getter;

@Getter 
public class NotBlankException extends RuntimeException {
    
    private DomainErrorCodeEnums errorCodeEnums;
    
    public NotBlankException(DomainErrorCodeEnums errorCodeEnums) {
        super(errorCodeEnums.getMessage());
        this.errorCodeEnums = errorCodeEnums;
    }
}
