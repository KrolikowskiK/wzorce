package com.example.order.decorator;

import com.example.item.Item;
import com.example.order.Order;

public class GiftWrappingDecorator extends OrderDecorator {

    public GiftWrappingDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double getTotal(Item item) {
        return super.getTotal(item) + 10.0;
    }

    @Override
    public String getOrderDetails() {
        return super.getOrderDetails() + " + gift packing";
    }
}

