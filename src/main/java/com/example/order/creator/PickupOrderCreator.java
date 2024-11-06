package com.example.order.creator;

import com.example.order.PickupOrder;
import com.example.order.command.OrderInvoker;

public class PickupOrderCreator extends OrderCreator {

    public PickupOrderCreator(OrderInvoker orderInvoker) {
        super(orderInvoker);
    }

    @Override
    public PickupOrder createOrder() {
        return new PickupOrder();
    }
}
