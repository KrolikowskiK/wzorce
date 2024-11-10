package com.example.order.modifiers;

import com.example.order.creator.Describer;

public abstract class OrderModifier implements Describer {
    protected Describer decoratedOrder;

    public OrderModifier(Describer decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public double getTotal() {
        return decoratedOrder.getTotal();
    }

    @Override
    public String getOrderDetails() {
        return decoratedOrder.getOrderDetails();
    }
}
