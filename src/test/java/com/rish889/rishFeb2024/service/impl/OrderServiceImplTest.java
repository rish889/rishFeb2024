package com.rish889.rishFeb2024.service.impl;

import com.rish889.rishFeb2024.exception.BadRequestException;
import com.rish889.rishFeb2024.model.Order;
import com.rish889.rishFeb2024.repository.DealRepository;
import com.rish889.rishFeb2024.repository.OrderRepository;
import com.rish889.rishFeb2024.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Mock
    DealRepository dealRepository;

    @Test
    void createOrder() {
        orderService = new OrderServiceImpl(orderRepository, dealRepository);
        Order order = Order.builder().dealId(1l).userId(2l).build();

        Mockito.when(orderRepository.findByDealIdAndUserId(1l, 2l)).thenReturn(Optional.of(new Order()));

        Exception exception = Assertions.assertThrows(BadRequestException.class, () -> {
            orderService.createOrder(order);
        });

        String expectedMessage = "Deal has already been claimed by you";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}