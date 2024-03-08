package com.rish889.rishFeb2024.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponseDto {
    private Long orderId;

    private Long userId;

    private Long dealId;
}
