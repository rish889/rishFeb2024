package com.rish889.rishFeb2024.dto.deal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDealResponseDto {
    private Long dealId;

    private String itemName;

    private Double itemPrice;

    private Long totalInventory;

    private Long bookedInventory;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
