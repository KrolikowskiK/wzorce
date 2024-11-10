package com.example.order.modifiers;

import com.example.order.creator.Describer;

public class GiftWrappingModifier extends OrderModifier {

    public GiftWrappingModifier(Describer decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double getTotal() {
        return super.getTotal() + 10.0;
    }

    @Override
    public String getOrderDetails() {
        return super.getOrderDetails() + " + gift packing";
    }
}

