package com.example;

import com.example.order.ExpressOrderCreator;
import com.example.order.OrderCreator;
import com.example.order.PickupOrderCreator;

public class Main {
    public static void main(String[] args) {
        // 1. factory method
        makeOrder("express");
        makeOrder("pickup");
    }

    public static void makeOrder(String type) {
        if (type.equals("express")) {
            OrderCreator creator = new ExpressOrderCreator();
            creator.processOrder();
        }
        if (type.equals("pickup")) {
            OrderCreator creator = new PickupOrderCreator();
            creator.processOrder();
        }
    }
}