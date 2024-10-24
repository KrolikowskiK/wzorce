package com.example.order;

import com.example.item.Item;

public class PickupOrder implements Order {
    @Override
    public double getTotal(Item item) {
        return item.getPrice() + 10;
    }

    @Override
    public String getOrderDetails() {
        return "you need to pick it yourself from nearest shop";
    }

    @Override
    public String getDeliveryTime() {
        return "usually couple of days";
    }
}
