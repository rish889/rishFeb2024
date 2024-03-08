package com.rish889.rishFeb2024.repository;

import com.rish889.rishFeb2024.model.Deal;
import com.rish889.rishFeb2024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DealRepository extends JpaRepository<Deal, Long> {
}
