package com.example.order.handler;

import com.example.order.Order;

import java.util.Random;

public class StockAvailabilityHandler extends OrderHandler {
    private boolean checkStock(Order order) {
        return new Random().nextBoolean();
    }

    @Override
    public void handle(Order order) {
        if (checkStock(order)) {
            System.out.println("Produkt dostępny w magazynie.");
            if (nextHandler != null) {
                nextHandler.handle(order);
            }
        } else {
            System.out.println("Produkt niedostępny.");
        }
    }
}