package com.example.order;

public class PickupOrder implements Order {
    @Override
    public double getTotal() {
        return 10;
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
