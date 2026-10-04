package com.supplierpulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.supplierpulse.service.AnalyticsService;
import com.supplierpulse.service.DeliveryService;
import com.supplierpulse.service.PurchaseOrderService;
import com.supplierpulse.service.QualityInspectionService;
import com.supplierpulse.service.SupplierService;

@Controller
public class DashboardController {

    private final SupplierService supplierService;
    private final PurchaseOrderService purchaseOrderService;
    private final DeliveryService deliveryService;
    private final QualityInspectionService qualityInspectionService;
    private final AnalyticsService analyticsService;

    public DashboardController(
            SupplierService supplierService,
            PurchaseOrderService purchaseOrderService,
            DeliveryService deliveryService,
            QualityInspectionService qualityInspectionService,
            AnalyticsService analyticsService) {

        this.supplierService = supplierService;
        this.purchaseOrderService = purchaseOrderService;
        this.deliveryService = deliveryService;
        this.qualityInspectionService = qualityInspectionService;
        this.analyticsService = analyticsService;
    }

    @GetMapping("/")
    public String showDashboard(Model model) {

        model.addAttribute(
                "supplierCount",
                supplierService.getSupplierCount()
        );

        model.addAttribute(
                "purchaseOrderCount",
                purchaseOrderService.getPurchaseOrderCount()
        );

        model.addAttribute(
                "deliveryCount",
                deliveryService.getDeliveryCount()
        );

        model.addAttribute(
                "qualityInspectionCount",
                qualityInspectionService.getQualityInspectionCount()
        );

        model.addAttribute(
                "analytics",
                analyticsService.getSupplierAnalytics()
        );

        return "dashboard";
    }
}