package com.example.payment.method;

public class PaypalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Płatność przez PayPal: " + amount);
    }
}