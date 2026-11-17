package com.example.clean_architecture.presentation.rest.exception;

import com.example.clean_architecture.infrastructure.persistence.enums.ErrorCodeEnum;

public class NotFoundException extends RuntimeException {
     private  ErrorCodeEnum errorCodeEnum;
    public NotFoundException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
    }
    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }
}
