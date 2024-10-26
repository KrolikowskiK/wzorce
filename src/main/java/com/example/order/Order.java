package com.example.order;

import com.example.item.Item;
import com.example.payment.strategy.PaymentStrategy;

public abstract class Order {
    protected PaymentStrategy paymentStrategy;

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
