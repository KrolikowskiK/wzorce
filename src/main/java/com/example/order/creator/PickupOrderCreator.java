package com.example.order.creator;

import com.example.order.PickupOrder;
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
