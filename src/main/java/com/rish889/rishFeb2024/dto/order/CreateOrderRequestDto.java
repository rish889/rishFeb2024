package com.rish889.rishFeb2024.dto.order;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequestDto {
    @Positive(message = "Please provide valid orderId")
    private Long userId;

    @Positive(message = "Please provide valid orderId")
    private Long dealId;
}
