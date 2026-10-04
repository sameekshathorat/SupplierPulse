package com.supplierpulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplierpulse.model.Analytics;
import com.supplierpulse.repository.AnalyticsRepository;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public List<Analytics> getSupplierAnalytics() {
        return analyticsRepository.getSupplierAnalytics();
    }
}
