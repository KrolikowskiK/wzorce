package com.example.order.creator;

import com.example.order.ExpressOrder;
import com.example.payment.PaymentProcessor;

// Lab 1 start Factory method
public class ExpressOrderCreator extends OrderCreator {

    public ExpressOrderCreator(PaymentProcessor pp) {
        super(pp);
    }

    @Override
    public ExpressOrder createOrder() {
        return new ExpressOrder();
    }
}
