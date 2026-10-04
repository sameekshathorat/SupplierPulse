package com.supplierpulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplierpulse.model.Supplier;
import com.supplierpulse.repository.SupplierRepository;

@Service
public class SupplierService {
    public int getSupplierCount() {

    return supplierRepository.getSupplierCount();
}

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.getAllSuppliers();
    }

    public void addSupplier(Supplier supplier) {
        supplierRepository.addSupplier(supplier);
    }
}