package com.example.order;

import com.example.item.Item;
import com.example.order.observer.OrderObserver;
import com.example.payment.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected PaymentStrategy paymentStrategy;
    private List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String status) {
        for (OrderObserver observer : observers) {
            observer.update(status);
        }
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        this.paymentStrategy.pay(amount);
    }

    public abstract double getTotal(Item item);
    public abstract String getOrderDetails();
    public abstract String getDeliveryTime();
}
