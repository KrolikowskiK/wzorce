package com.example.payment.strategy;

import com.example.payment.service.PaymentAdapter;
import com.example.payment.service.PaymentProcessor;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        PaymentProcessor paymentProcessor = PaymentAdapter.getPaymentAdapter();
        System.out.println("Płatność przez PayPal: " + amount);
        paymentProcessor.processPayment(amount);
    }
}