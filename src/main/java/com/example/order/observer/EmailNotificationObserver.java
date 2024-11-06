package com.example.order.observer;

public class EmailNotificationObserver implements OrderObserver {
    @Override
    public void update(String status) {
        System.out.println("Wysłano e-mail: Status zamówienia zmienił się na " + status);
    }
}