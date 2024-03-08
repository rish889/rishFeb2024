package com.rish889.rishFeb2024.service.impl;

import com.rish889.rishFeb2024.exception.BadRequestException;
import com.rish889.rishFeb2024.model.Deal;
import com.rish889.rishFeb2024.repository.DealRepository;
import com.rish889.rishFeb2024.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Override
    public Deal createDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    @Transactional
    public Deal updateDeal(Deal newDeal) {
        Optional<Deal> dealOptional = dealRepository.findById(newDeal.getDealId());
        if (dealOptional.isEmpty()) {
            throw new BadRequestException("deal_does_not_exists", "Deal does not exists");
        }

        Deal fetchedDeal = dealOptional.get();
        fetchedDeal.setTotalInventory(newDeal.getTotalInventory());
        fetchedDeal.setEndTime(newDeal.getEndTime());

        return dealRepository.save(fetchedDeal);
    }
}
