package com.rish889.rishFeb2024.controller;

import com.rish889.rishFeb2024.config.ApiPaths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthController {

    @GetMapping(ApiPaths.HEALTH_CHECK)
    private String healthCheck() {
        log.info("rish889 Api is healthy.");
        return "rish889 Api is healthy.";
    }
}