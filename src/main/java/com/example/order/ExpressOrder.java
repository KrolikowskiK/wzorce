package com.example.order;

import com.example.item.Item;

public class ExpressOrder implements Order {
    @Override
    public double getTotal(Item item) {
        return item.getPrice() + 100;
    }

    @Override
    public String getOrderDetails() {
        return "delivered via drone";
    }

    @Override
    public String getDeliveryTime() {
        return "exxxtra fast";
    }
}
