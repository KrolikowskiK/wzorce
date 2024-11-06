package com.example.order.handler;

import com.example.order.Order;

import java.util.Random;

public class PaymentVerificationHandler extends OrderHandler {
    private boolean verifyPayment(Order order) {
        return new Random().nextBoolean();
    }

    @Override
    public void handle(Order order) {
        if (verifyPayment(order)) {
            System.out.println("Płatność zatwierdzona.");
            if (nextHandler != null) {
                nextHandler.handle(order);
            }
        } else {
            System.out.println("Płatność odrzucona.");
        }
    }
}