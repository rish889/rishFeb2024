package com.rish889.rishFeb2024.service.impl;

import com.rish889.rishFeb2024.exception.BadRequestException;
import com.rish889.rishFeb2024.model.Deal;
import com.rish889.rishFeb2024.model.Order;
import com.rish889.rishFeb2024.repository.DealRepository;
import com.rish889.rishFeb2024.repository.OrderRepository;
import com.rish889.rishFeb2024.service.DealService;
import com.rish889.rishFeb2024.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DealRepository dealRepository;

    @Override
    @Transactional
    public Order createOrder(Order order) {
        Optional<Order> orderOptional = orderRepository.findByDealIdAndUserId(order.getDealId(), order.getUserId());
        if (orderOptional.isPresent()) {
            throw new BadRequestException("deal_already_claimed", "Deal has already been claimed by you");
        }

        Optional<Deal> dealOptional = dealRepository.findById(order.getDealId());
        if (dealOptional.isEmpty()) {
            throw new BadRequestException("deal_not_found", "Deal does not exists");
        }

        Deal deal = dealOptional.get();

        if (deal.getBookedInventory() >= deal.getTotalInventory()) {
            throw new BadRequestException("deal_sold_out", "Deal is sold out");
        }

        if (deal.getStartTime().isAfter(LocalDateTime.now())) {
            throw new BadRequestException("deal_yet_to_begin", "Deal is yet to begin");
        }

        if (deal.getEndTime().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("deal_is_over", "Deal is over");
        }

        deal.setBookedInventory(deal.getBookedInventory() + 1);
        dealRepository.save(deal);

        return orderRepository.save(order);
    }
}
