package com.example.order.decorator;

import com.example.item.Item;
import com.example.order.Order;

public class DiscountDecorator extends OrderDecorator {
    private double discount;

    public DiscountDecorator(Order decoratedOrder, double discount) {
        super(decoratedOrder);
        this.discount = discount;
    }

    @Override
    public double getTotal(Item item) {
        return super.getTotal(item) - discount;
    }

    @Override
    public String getOrderDetails() {
        return super.getOrderDetails() + " + !1! discount !!";
    }
}
