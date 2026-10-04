package com.supplierpulse.model;

import java.time.LocalDate;

public class PurchaseOrder {

    private int orderId;
    private int supplierId;
    private LocalDate orderDate;
    private LocalDate expectedDeliveryDate;
    private String status;

    public PurchaseOrder() {
    }

    public PurchaseOrder(int orderId, int supplierId,
                         LocalDate orderDate,
                         LocalDate expectedDeliveryDate,
                         String status) {

        this.orderId = orderId;
        this.supplierId = supplierId;
        this.orderDate = orderDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
