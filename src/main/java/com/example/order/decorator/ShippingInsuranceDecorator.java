package com.example.order.decorator;

import com.example.item.Item;
import com.example.order.Order;

public class ShippingInsuranceDecorator extends OrderDecorator {

    public ShippingInsuranceDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double getTotal(Item item) {
        return super.getTotal(item) + 40.0;
    }

    @Override
    public String getOrderDetails() {
        return super.getOrderDetails() + " + shipping insurance cost";
    }
}

