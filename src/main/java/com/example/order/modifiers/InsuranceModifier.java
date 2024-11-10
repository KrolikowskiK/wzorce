package com.example.order.modifiers;

import com.example.order.creator.Describer;

public class InsuranceModifier extends OrderModifier {

    public InsuranceModifier(Describer decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double getTotal() {
        return super.getTotal() + 40.0;
    }

    @Override
    public String getOrderDetails() {
        return super.getOrderDetails() + " + insurance cost";
    }
}

