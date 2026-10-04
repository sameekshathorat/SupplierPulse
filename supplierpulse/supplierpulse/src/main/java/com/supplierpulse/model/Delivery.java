package com.supplierpulse.model;

import java.time.LocalDate;

public class Delivery {

    private int deliveryId;
    private int orderId;
    private LocalDate actualDeliveryDate;
    private double quantityReceived;
    private String deliveryStatus;

    public Delivery() {
    }

    public Delivery(int deliveryId,
                    int orderId,
                    LocalDate actualDeliveryDate,
                    double quantityReceived,
                    String deliveryStatus) {

        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.actualDeliveryDate = actualDeliveryDate;
        this.quantityReceived = quantityReceived;
        this.deliveryStatus = deliveryStatus;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public double getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(double quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}