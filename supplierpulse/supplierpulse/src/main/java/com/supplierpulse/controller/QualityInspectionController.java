package com.supplierpulse.controller;

import com.supplierpulse.model.QualityInspection;
import com.supplierpulse.service.DeliveryService;
import com.supplierpulse.service.QualityInspectionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quality-inspections")
public class QualityInspectionController {

    private final QualityInspectionService qualityInspectionService;
    private final DeliveryService deliveryService;

    public QualityInspectionController(
            QualityInspectionService qualityInspectionService,
            DeliveryService deliveryService) {

        this.qualityInspectionService = qualityInspectionService;
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public String showQualityInspections(Model model) {

        model.addAttribute(
                "inspections",
                qualityInspectionService.getAllInspections()
        );

        model.addAttribute(
                "inspection",
                new QualityInspection()
        );

        model.addAttribute(
                "deliveries",
                deliveryService.getAllDeliveries()
        );

        return "quality-inspections";
    }

    @PostMapping("/add")
    public String addInspection(
            @ModelAttribute QualityInspection inspection) {

        qualityInspectionService.addInspection(inspection);

        return "redirect:/quality-inspections";
    }

    @GetMapping("/delete/{id}")
    public String deleteInspection(
            @PathVariable("id") int inspectionId) {

        qualityInspectionService.deleteInspection(inspectionId);

        return "redirect:/quality-inspections";
    }
}