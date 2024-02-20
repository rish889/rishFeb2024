package com.rish889.rishFeb2024.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestControllerAdvice
@Slf4j
class RestExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<ErrorDetails> handleAllOtherExceptions(Exception ex) {
        log.error("Exception : {}.", ex);
        final ErrorDetails errorDetails = ErrorDetails.builder()
                .errorDetails(Arrays.asList(ErrorDetail.builder().errorCode("internal_server_error").message("Something Went Wrong").build()))
                .build();
        return ResponseEntity.internalServerError().body(errorDetails);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ErrorDetails> handleBadRequestException(BadRequestException ex) {

        final List<ErrorDetail> errorDetailList;
        if (Objects.nonNull(ex.getErrorCode())) {
            log.error("ExceptionMessage : {}.", ex.getMessage());
            errorDetailList = Arrays.asList(ErrorDetail.builder().errorCode(ex.getErrorCode()).message(ex.getMessage()).build());
        } else {
            log.error("ExceptionMessage : {}.", ex.getErrorDetails().stream().map(ed -> ed.getMessage()).collect(Collectors.toList()));
            errorDetailList = ex.getErrorDetails();
        }

        final ErrorDetails errorDetails = ErrorDetails.builder()
                .errorDetails(errorDetailList)
                .build();
        return ResponseEntity.badRequest().body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("ExceptionMessage : {}.", ex.getMessage());
        final List<ErrorDetail> errorMessages = ex.getAllErrors().stream()
                .map(fieldError -> ErrorDetail.builder()
                        .message(fieldError.getDefaultMessage())
                        .errorCode("invalid_method_arguement")
                        .build())
                .collect(Collectors.toList());
        final ErrorDetails errorDetails = ErrorDetails.builder()
                .errorDetails(errorMessages)
                .build();
        return ResponseEntity.badRequest().body(errorDetails);
    }
}

