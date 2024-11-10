package com.example.order.modifiers;

import com.example.order.creator.Describer;

import java.util.Random;

public class DiscountModifier extends OrderModifier {
    public DiscountModifier(Describer decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double getTotal() {
        return super.getTotal() * new Random().nextDouble(0, 0.5);
    }

    @Override
    public String getOrderDetails() {
        return super.getOrderDetails() + " + !1! discount !!";
    }
}
