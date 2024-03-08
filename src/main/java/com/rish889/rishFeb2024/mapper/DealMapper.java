package com.rish889.rishFeb2024.mapper;

import com.rish889.rishFeb2024.dto.deal.CreateDealRequestDto;
import com.rish889.rishFeb2024.dto.deal.CreateDealResponseDto;
import com.rish889.rishFeb2024.dto.deal.UpdateDealRequestDto;
import com.rish889.rishFeb2024.model.Deal;


public class DealMapper {
    public static Deal convertToEntity(final CreateDealRequestDto dto) {
        final Deal entity = Deal.builder()
                .itemName(dto.getItemName())
                .itemPrice(dto.getItemPrice())
                .totalInventory(dto.getTotalInventory())
                .bookedInventory(0l)
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .build();
        return entity;
    }

    public static Deal convertToEntity(final UpdateDealRequestDto dto) {
        final Deal entity = Deal.builder()
                .dealId(dto.getDealId())
                .totalInventory(dto.getTotalInventory())
                .endTime(dto.getEndTime())
                .build();
        return entity;
    }

    public static CreateDealResponseDto convertDto(final Deal entity) {
        final CreateDealResponseDto dto = CreateDealResponseDto.builder()
                .dealId(entity.getDealId())
                .itemName(entity.getItemName())
                .itemPrice(entity.getItemPrice())
                .totalInventory(entity.getTotalInventory())
                .bookedInventory(entity.getBookedInventory())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .build();
        return dto;
    }
}
