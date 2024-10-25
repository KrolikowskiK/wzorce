package com.example.order;

import com.example.payment.PaymentProcessor;

public class ExpressOrderCreator extends OrderCreator {

    public ExpressOrderCreator(PaymentProcessor pp) {
        super(pp);
    }

    @Override
    public ExpressOrder createOrder() {
        return new ExpressOrder();
    }
}
