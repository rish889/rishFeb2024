package com.rish889.rishFeb2024.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorDetails {
    private List<ErrorDetail> errorDetails;
}
