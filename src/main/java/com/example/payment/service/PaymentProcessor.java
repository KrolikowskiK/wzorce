package com.example.payment.service;

import com.example.payment.method.PaymentMethod;

public interface PaymentProcessor {
    void processPayment(PaymentMethod method, double amount);
}
