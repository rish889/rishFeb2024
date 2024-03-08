package com.rish889.rishFeb2024.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    @Getter
    private String errorCode;

    @Getter
    private List<ErrorDetail> errorDetails;

    public BadRequestException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BadRequestException(List<ErrorDetail> errorDetails) {
        super();
        this.errorDetails = errorDetails;
    }
}
