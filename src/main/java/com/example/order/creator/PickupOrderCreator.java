package com.example.order.creator;

import com.example.order.PickupOrder;

public class PickupOrderCreator extends OrderCreator {

    @Override
    public PickupOrder createOrder() {
        return new PickupOrder();
    }
}
