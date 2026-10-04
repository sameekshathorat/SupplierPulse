package com.supplierpulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplierpulse.model.Delivery;
import com.supplierpulse.repository.DeliveryRepository;

@Service
public class DeliveryService {
    public int getDeliveryCount() {

    return deliveryRepository.getDeliveryCount();
}

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    // Add Delivery
    public void addDelivery(Delivery delivery) {
        deliveryRepository.addDelivery(delivery);
    }

    // Get All Deliveries
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.getAllDeliveries();
    }

    // Get Delivery By ID
    public Delivery getDeliveryById(int deliveryId) {
        return deliveryRepository.getDeliveryById(deliveryId);
    }

    // Update Delivery
    public void updateDelivery(Delivery delivery) {
        deliveryRepository.updateDelivery(delivery);
    }

    // Delete Delivery
    public void deleteDelivery(int deliveryId) {
        deliveryRepository.deleteDelivery(deliveryId);
    }
}