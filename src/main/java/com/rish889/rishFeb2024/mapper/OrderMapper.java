package com.rish889.rishFeb2024.mapper;

import com.rish889.rishFeb2024.dto.order.CreateOrderRequestDto;
import com.rish889.rishFeb2024.dto.order.CreateOrderResponseDto;
import com.rish889.rishFeb2024.model.Order;


public class OrderMapper {
    public static Order convertToEntity(final CreateOrderRequestDto dto) {
        final Order entity = Order.builder()
                .userId(dto.getUserId())
                .dealId(dto.getDealId())
                .build();
        return entity;
    }

    public static CreateOrderResponseDto convertDto(final Order entity) {
        final CreateOrderResponseDto dto = CreateOrderResponseDto.builder()
                .orderId(entity.getOrderId())
                .userId(entity.getUserId())
                .dealId(entity.getDealId())
                .build();
        return dto;
    }
}
