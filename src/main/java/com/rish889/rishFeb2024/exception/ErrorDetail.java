package com.rish889.rishFeb2024.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetail {
    private String message;

    private String errorCode;
}
