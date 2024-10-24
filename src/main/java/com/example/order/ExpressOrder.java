package com.example.order;

public class ExpressOrder implements Order {
    @Override
    public double getTotal() {
        return 100;
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
