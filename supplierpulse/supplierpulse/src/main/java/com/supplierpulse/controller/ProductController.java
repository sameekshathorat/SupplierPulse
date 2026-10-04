package com.supplierpulse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.supplierpulse.model.Product;
import com.supplierpulse.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", new Product());

        return "products";
    }

    @PostMapping("/products/add")
    public String addProduct(Product product) {

        productService.addProduct(product);

        return "redirect:/products";
    }
}
