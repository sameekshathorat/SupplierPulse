package com.supplierpulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supplierpulse.model.Delivery;
import com.supplierpulse.service.DeliveryService;
import com.supplierpulse.service.PurchaseOrderService;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final PurchaseOrderService purchaseOrderService;

    public DeliveryController(DeliveryService deliveryService,
                              PurchaseOrderService purchaseOrderService) {

        this.deliveryService = deliveryService;
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping
    public String showDeliveries(Model model) {

        model.addAttribute(
                "deliveries",
                deliveryService.getAllDeliveries()
        );

        model.addAttribute(
                "delivery",
                new Delivery()
        );

        model.addAttribute(
                "purchaseOrders",
                purchaseOrderService.getAllPurchaseOrders()
        );

        return "deliveries";
    }

    @PostMapping("/add")
    public String addDelivery(
            @ModelAttribute Delivery delivery) {

        deliveryService.addDelivery(delivery);

        return "redirect:/deliveries";
    }

    @GetMapping("/delete/{id}")
    public String deleteDelivery(
            @PathVariable("id") int deliveryId) {

        deliveryService.deleteDelivery(deliveryId);

        return "redirect:/deliveries";
    }
}