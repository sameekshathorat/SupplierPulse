package com.supplierpulse.model;

public class Analytics {

    private int supplierId;
    private String supplierName;
    private double onTimeRate;
    private double qualityRate;
    private double overallScore;

    public Analytics() {
    }

    public Analytics(int supplierId,
                     String supplierName,
                     double onTimeRate,
                     double qualityRate,
                     double overallScore) {

        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.onTimeRate = onTimeRate;
        this.qualityRate = qualityRate;
        this.overallScore = overallScore;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public double getOnTimeRate() {
        return onTimeRate;
    }

    public void setOnTimeRate(double onTimeRate) {
        this.onTimeRate = onTimeRate;
    }

    public double getQualityRate() {
        return qualityRate;
    }

    public void setQualityRate(double qualityRate) {
        this.qualityRate = qualityRate;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public String getPerformanceLevel() {

        if (overallScore >= 90) {
            return "Excellent";
        } else if (overallScore >= 75) {
            return "Good";
        } else if (overallScore >= 60) {
            return "Average";
        } else {
            return "Poor";
        }
    }
}