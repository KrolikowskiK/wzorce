package com.example.order.mediator;

public interface OrderMediator {
    void validateCart();
    boolean checkInventory();
    void processPayment();
}
