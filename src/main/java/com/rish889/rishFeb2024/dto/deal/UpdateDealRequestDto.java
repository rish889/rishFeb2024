package com.rish889.rishFeb2024.dto.deal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDealRequestDto {
    @Positive(message = "Please provide valid dealId")
    private Long dealId;

    @Positive(message = "Please provide valid totalInventory")
    private Long totalInventory;

    @NotNull(message = "endTime must not be null")
    private LocalDateTime endTime;
}
