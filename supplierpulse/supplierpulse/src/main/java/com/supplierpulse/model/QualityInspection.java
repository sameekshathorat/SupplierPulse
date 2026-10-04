package com.supplierpulse.model;

import java.time.LocalDate;

public class QualityInspection {

    private int inspectionId;
    private int deliveryId;
    private LocalDate inspectionDate;
    private double quantityInspected;
    private double quantityAccepted;
    private double quantityRejected;
    private String remarks;

    public QualityInspection() {
    }

    public QualityInspection(int inspectionId,
                             int deliveryId,
                             LocalDate inspectionDate,
                             double quantityInspected,
                             double quantityAccepted,
                             double quantityRejected,
                             String remarks) {

        this.inspectionId = inspectionId;
        this.deliveryId = deliveryId;
        this.inspectionDate = inspectionDate;
        this.quantityInspected = quantityInspected;
        this.quantityAccepted = quantityAccepted;
        this.quantityRejected = quantityRejected;
        this.remarks = remarks;
    }

    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public double getQuantityInspected() {
        return quantityInspected;
    }

    public void setQuantityInspected(double quantityInspected) {
        this.quantityInspected = quantityInspected;
    }

    public double getQuantityAccepted() {
        return quantityAccepted;
    }

    public void setQuantityAccepted(double quantityAccepted) {
        this.quantityAccepted = quantityAccepted;
    }

    public double getQuantityRejected() {
        return quantityRejected;
    }

    public void setQuantityRejected(double quantityRejected) {
        this.quantityRejected = quantityRejected;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}