package com.example.order.decorator;

import com.example.item.Item;
import com.example.order.Order;

public abstract class OrderDecorator implements Order {
    protected Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public double getTotal(Item item) {
        return decoratedOrder.getTotal(item);
    }

    @Override
    public String getOrderDetails() {
        return decoratedOrder.getOrderDetails();
    }

    @Override
    public String getDeliveryTime() {
        return decoratedOrder.getDeliveryTime();
    }
}
