package com.rish889.rishFeb2024.controller;

import com.rish889.rishFeb2024.dto.order.CreateOrderRequestDto;
import com.rish889.rishFeb2024.dto.order.CreateOrderResponseDto;
import com.rish889.rishFeb2024.mapper.OrderMapper;
import com.rish889.rishFeb2024.model.Deal;
import com.rish889.rishFeb2024.model.Order;
import com.rish889.rishFeb2024.service.DealService;
import com.rish889.rishFeb2024.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/api/v1/rish889/orders")
    public @ResponseBody ResponseEntity<CreateOrderResponseDto> createOrder(@Valid @RequestBody CreateOrderRequestDto dto) {
        log.info("createOrder(). requestDto : {}", dto);
        final Order createdOrder = orderService.createOrder(OrderMapper.convertToEntity(dto));

        log.info("createOrder() successful. responseDto : {}", createdOrder);
        return ResponseEntity.ok(OrderMapper.convertDto(createdOrder));
    }
}
