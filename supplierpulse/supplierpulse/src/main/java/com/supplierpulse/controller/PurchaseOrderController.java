package com.supplierpulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supplierpulse.model.PurchaseOrder;
import com.supplierpulse.service.PurchaseOrderService;
import com.supplierpulse.service.SupplierService;

@Controller
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;
    private final SupplierService supplierService;

    public PurchaseOrderController(
            PurchaseOrderService purchaseOrderService,
            SupplierService supplierService) {

        this.purchaseOrderService = purchaseOrderService;
        this.supplierService = supplierService;
    }

    // Show Purchase Orders
    @GetMapping
    public String showPurchaseOrders(Model model) {

        model.addAttribute(
                "purchaseOrders",
                purchaseOrderService.getAllPurchaseOrders()
        );

        model.addAttribute(
                "suppliers",
                supplierService.getAllSuppliers()
        );

        model.addAttribute(
                "purchaseOrder",
                new PurchaseOrder()
        );

        return "purchase-orders";
    }

    // Add Purchase Order
    @PostMapping("/add")
    public String addPurchaseOrder(
            @ModelAttribute PurchaseOrder purchaseOrder) {

        purchaseOrderService.addPurchaseOrder(purchaseOrder);

        return "redirect:/purchase-orders";
    }

    // Show Edit Form
    @GetMapping("/edit/{id}")
    public String editPurchaseOrder(
            @PathVariable("id") int orderId,
            Model model) {

        model.addAttribute(
                "purchaseOrder",
                purchaseOrderService.getPurchaseOrderById(orderId)
        );

        model.addAttribute(
                "purchaseOrders",
                purchaseOrderService.getAllPurchaseOrders()
        );

        model.addAttribute(
                "suppliers",
                supplierService.getAllSuppliers()
        );

        return "purchase-orders";
    }

    // Update Purchase Order
    @PostMapping("/update")
    public String updatePurchaseOrder(
            @ModelAttribute PurchaseOrder purchaseOrder) {

        purchaseOrderService.updatePurchaseOrder(purchaseOrder);

        return "redirect:/purchase-orders";
    }

    // Delete Purchase Order
    @GetMapping("/delete/{id}")
    public String deletePurchaseOrder(
            @PathVariable("id") int orderId) {

        purchaseOrderService.deletePurchaseOrder(orderId);

        return "redirect:/purchase-orders";
    }
}