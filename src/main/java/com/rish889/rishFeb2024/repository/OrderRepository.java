package com.rish889.rishFeb2024.repository;

import com.rish889.rishFeb2024.model.Deal;
import com.rish889.rishFeb2024.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByDealIdAndUserId(Long dealId, Long userId);
}
