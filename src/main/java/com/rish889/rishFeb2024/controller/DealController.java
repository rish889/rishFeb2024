package com.rish889.rishFeb2024.controller;

import com.rish889.rishFeb2024.dto.deal.CreateDealRequestDto;
import com.rish889.rishFeb2024.dto.deal.CreateDealResponseDto;
import com.rish889.rishFeb2024.dto.deal.UpdateDealRequestDto;
import com.rish889.rishFeb2024.mapper.DealMapper;
import com.rish889.rishFeb2024.model.Deal;
import com.rish889.rishFeb2024.service.DealService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DealController {
    @Autowired
    private DealService dealService;

    @PostMapping("/api/v1/rish889/deals")
    public @ResponseBody ResponseEntity<CreateDealResponseDto> createDeal(@Valid @RequestBody CreateDealRequestDto dto) {
        log.info("createDeal(). requestDto : {}", dto);
        final Deal createdDeal = dealService.createDeal(DealMapper.convertToEntity(dto));

        log.info("createDeal() successful. responseDto : {}", createdDeal);
        return ResponseEntity.ok(DealMapper.convertDto(createdDeal));
    }

    @PutMapping("/api/v1/rish889/deals")
    public @ResponseBody ResponseEntity<CreateDealResponseDto> updateDeal(@Valid @RequestBody UpdateDealRequestDto dto) {
        log.info("updateDeal(). requestDto : {}", dto);
        final Deal updatedDeal = dealService.updateDeal(DealMapper.convertToEntity(dto));

        log.info("updateDeal() successful. responseDto : {}", updatedDeal);
        return ResponseEntity.ok(DealMapper.convertDto(updatedDeal));
    }
}
