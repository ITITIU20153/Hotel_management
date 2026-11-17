package com.example.clean_architecture.domain.exception;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;

public class RoomNotAvailableException extends RuntimeException {
    private DomainErrorCodeEnums domainErrorCodeEnums;
    
    public RoomNotAvailableException(DomainErrorCodeEnums domainErrorCodeEnums) {
        super(domainErrorCodeEnums.getMessage());
        this.domainErrorCodeEnums = domainErrorCodeEnums;
    }

    public DomainErrorCodeEnums getDomainErrorCodeEnums() {
        return domainErrorCodeEnums;
    }
}
