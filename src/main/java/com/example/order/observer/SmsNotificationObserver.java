package com.example.order.observer;

public class SmsNotificationObserver implements OrderObserver {
    @Override
    public void update(String status) {
        System.out.println("Wysłano SMS: Status zamówienia zmienił się na " + status);
    }
}