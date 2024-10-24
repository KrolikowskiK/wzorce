package com.example.order;

public class ExpressOrderCreator extends OrderCreator {

    @Override
    public ExpressOrder createOrder() {
        return new ExpressOrder();
    }
}
