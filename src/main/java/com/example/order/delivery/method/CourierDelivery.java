package com.example.order.delivery.method;

import com.example.order.delivery.Deliverer;

public abstract class CourierDelivery implements Deliverer {
    protected abstract String informDeliveryService(String orderId);

    @Override
    public void deliver(String orderId) {
        String delivererName = informDeliveryService(orderId);
        System.out.println("Firma kurierska " + delivererName + " dostarczy twoje zamówienie o numerze " + orderId);
    }
}
