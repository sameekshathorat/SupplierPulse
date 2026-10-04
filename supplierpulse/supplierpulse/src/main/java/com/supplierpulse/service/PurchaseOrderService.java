package com.supplierpulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplierpulse.model.PurchaseOrder;
import com.supplierpulse.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
    public int getPurchaseOrderCount() {

    return purchaseOrderRepository.getPurchaseOrderCount();
}

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public void addPurchaseOrder(PurchaseOrder order) {
        purchaseOrderRepository.addPurchaseOrder(order);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.getAllPurchaseOrders();
    }

    public PurchaseOrder getPurchaseOrderById(int orderId) {
        return purchaseOrderRepository.getPurchaseOrderById(orderId);
    }

    public void updatePurchaseOrder(PurchaseOrder order) {
        purchaseOrderRepository.updatePurchaseOrder(order);
    }

    public void deletePurchaseOrder(int orderId) {
        purchaseOrderRepository.deletePurchaseOrder(orderId);
    }
}