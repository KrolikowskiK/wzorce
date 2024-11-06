package com.example.order.creator;

import com.example.order.ExpressOrder;
import com.example.order.command.OrderInvoker;

public class ExpressOrderCreator extends OrderCreator {

    public ExpressOrderCreator(OrderInvoker orderInvoker) {
        super(orderInvoker);
    }

    @Override
    public ExpressOrder createOrder() {
        return new ExpressOrder();
    }
}
