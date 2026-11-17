package com.example.clean_architecture.domain.model.user;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;
import com.example.clean_architecture.domain.exception.NotBlankException;

public record Password(String value) {
    public Password {
        if (value.isBlank()) {
            throw new NotBlankException(DomainErrorCodeEnums.PASSWORD_NOT_BLANK);
        }

    }
}
