package com.supplierpulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.supplierpulse.service.AnalyticsService;

@Controller
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/analytics")
    public String showAnalytics(Model model) {

        model.addAttribute(
                "analytics",
                analyticsService.getSupplierAnalytics()
        );

        return "analytics";
    }
}