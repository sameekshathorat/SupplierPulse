package com.supplierpulse.model;

public class Supplier {

    private int supplierId;
    private String supplierName;
    private String companyName;
    private String contactNumber;
    private String email;
    private String address;
    private String category;
    private String status;

    public Supplier() {
    }

    public Supplier(int supplierId, String supplierName, String companyName,
                    String contactNumber, String email, String address,
                    String category, String status) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.companyName = companyName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.category = category;
        this.status = status;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
