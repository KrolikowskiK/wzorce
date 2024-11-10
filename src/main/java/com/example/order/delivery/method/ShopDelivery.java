package com.example.order.delivery.method;

import com.example.order.delivery.Deliverer;

public class ShopDelivery implements Deliverer {
    @Override
    public void deliver(String orderId) {
        System.out.println("Twoje zamówienie nr " + orderId + " zostanie dostarczone do sklepu");
    }
}
