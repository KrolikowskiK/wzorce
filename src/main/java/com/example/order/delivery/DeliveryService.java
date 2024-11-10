package com.example.order.delivery;

public class DeliveryService {
    public void commissionDelivery(String orderId, Deliverer deliverer) {
        deliverer.deliver(orderId);
    }
}
