package com.example.order;

public class PickupOrderCreator extends OrderCreator {

    @Override
    public PickupOrder createOrder() {
        return new PickupOrder();
    }
}
