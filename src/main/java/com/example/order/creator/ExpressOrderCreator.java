package com.example.order.creator;

import com.example.order.ExpressOrder;
import com.example.payment.service.PaymentProcessor;

public class ExpressOrderCreator extends OrderCreator {

    @Override
    public ExpressOrder createOrder() {
        return new ExpressOrder();
    }
}
