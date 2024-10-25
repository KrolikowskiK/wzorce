package com.example.order;

import com.example.payment.PaymentProcessor;

public class PickupOrderCreator extends OrderCreator {

    public PickupOrderCreator(PaymentProcessor pp) {
        super(pp);
    }

    @Override
    public PickupOrder createOrder() {
        return new PickupOrder();
    }
}
