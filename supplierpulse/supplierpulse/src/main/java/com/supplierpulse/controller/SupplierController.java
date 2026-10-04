package com.supplierpulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supplierpulse.model.Supplier;
import com.supplierpulse.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {

        this.supplierService = supplierService;
    }

    // Show Suppliers
    @GetMapping
    public String showSuppliers(Model model) {

        model.addAttribute(
                "suppliers",
                supplierService.getAllSuppliers()
        );

        model.addAttribute(
                "supplier",
                new Supplier()
        );

        return "suppliers";
    }

    // Add Supplier
    @PostMapping("/add")
    public String addSupplier(
            @ModelAttribute Supplier supplier) {

        supplierService.addSupplier(supplier);

        return "redirect:/suppliers";
    }
}