package com.supplierpulse.model;

public class Product {

    private int productId;
    private String productName;
    private String category;
    private String unit;
    private double unitPrice;

    public Product() {
    }

    public Product(int productId, String productName, String category,
                   String unit, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.unit = unit;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
