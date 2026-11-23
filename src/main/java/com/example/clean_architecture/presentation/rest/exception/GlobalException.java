package com.example.clean_architecture.presentation.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.clean_architecture.domain.enums.DomainErrorCodeEnums;
import com.example.clean_architecture.domain.exception.DomainException;
import com.example.clean_architecture.domain.exception.NotBlankException;
import com.example.clean_architecture.domain.exception.NotNullException;
import com.example.clean_architecture.infrastructure.persistence.enums.ErrorCodeEnum;

@RestControllerAdvice 
public class GlobalException {
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(
            DomainException ex
    ) {
        DomainErrorCodeEnums codeEnums = ex.getEnumCode();
        
        return ResponseEntity
                .status(codeEnums.getStatus())
                .body(toErrorDomainResponse(codeEnums));
    }


    @ExceptionHandler(NotBlankException.class)
    public ResponseEntity<ErrorResponse> handleNotBlankException(
            DomainException ex
    ) {
        DomainErrorCodeEnums codeEnums = ex.getEnumCode();
        
        return ResponseEntity
                .status(codeEnums.getStatus())
                .body(toErrorDomainResponse(codeEnums));
    }

    
    @ExceptionHandler(NotNullException.class)
    public ResponseEntity<ErrorResponse> handleNotNullException(
            DomainException ex
    ) {
        DomainErrorCodeEnums codeEnums = ex.getEnumCode();
        
        return ResponseEntity
                .status(codeEnums.getStatus())
                .body(toErrorDomainResponse(codeEnums));
    }

    @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<ErrorResponse> handleNotFound(
                NotFoundException ex) {

                ErrorCodeEnum errorCode = ex.getErrorCodeEnum();
                
                return ResponseEntity
                        .status(errorCode.getStatus().value())
                        .body(toErrorResponse(errorCode));
        }


        @ExceptionHandler(IllegalArgumentException.class) 
        public ResponseEntity<String> handleIllegalArgument(
                IllegalArgumentException ex) {

                // ErrorCodeEnum errorCode = ex.getErrorCodeEnum();
                
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ex.getMessage());
        }


         @ExceptionHandler(IllegalStateException.class) 
        public ResponseEntity<String> handleIllegalState(
                IllegalStateException ex) {

                // ErrorCodeEnum errorCode = ex.getErrorCodeEnum();
                
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ex.getMessage());
        }
        
    private ErrorResponse toErrorDomainResponse(DomainErrorCodeEnums e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode(e.getCode());
            errorResponse.setMessage(e.getMessage());
            errorResponse.setStatus(e.getStatus().value());
            return errorResponse;
    }

    private ErrorResponse toErrorResponse(ErrorCodeEnum e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode(e.getCode());
            errorResponse.setMessage(e.getMessage());
            errorResponse.setStatus(e.getStatus().value());
            return errorResponse;
        }
}
