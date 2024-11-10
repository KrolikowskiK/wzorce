package com.example.order.delivery.method;

public class InpostDelivery extends CourierDelivery {
    @Override
    protected String informDeliveryService(String orderId) {
        // logic with orderId, package registering etc.
        return "InPost";
    }
}
