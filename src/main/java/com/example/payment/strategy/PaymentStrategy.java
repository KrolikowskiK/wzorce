package com.example.payment.strategy;

import com.example.payment.service.PaymentProcessor;

public interface PaymentStrategy {
    void pay(double amount);
}
