package com.example.clean_architecture.domain.model.user;

import java.util.Objects;
import java.util.regex.Pattern;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;
import com.example.clean_architecture.domain.exception.DomainException;
import com.example.clean_architecture.domain.exception.NotNullException;


public record Username(String value) {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 30;

    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]*$");
   
    public Username {
        Objects.requireNonNull(value, "Username must not be null");

        if (value.isBlank()) {
            throw new NotNullException(DomainErrorCodeEnums.USERNAME_NOT_BLANK);
        }

        if (value.length() < MIN_LENGTH ||
            value.length() > MAX_LENGTH) {
            throw new DomainException(
                    DomainErrorCodeEnums.USERNAME_LENGTH
            );
        }

        if (!USERNAME_PATTERN.matcher(value).matches()) {
            throw new DomainException(
                    DomainErrorCodeEnums.USERNAME_INVALID
            );
        }
    }
}
