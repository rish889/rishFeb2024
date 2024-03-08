package com.rish889.rishFeb2024.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dealId;

    private String itemName;

    private Double itemPrice;

    private Long totalInventory;

    private Long bookedInventory;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}