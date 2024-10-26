package com.example.order;

import com.example.item.Item;

public class BasicOrder implements Order {
    @Override
    public double getTotal(Item item) {
        return item.getPrice() + 40;
    }

    @Override
    public String getOrderDetails() {
        return "basic order, nothing special";
    }

    @Override
    public String getDeliveryTime() {
        return "when it arrives, it is";
    }
}
