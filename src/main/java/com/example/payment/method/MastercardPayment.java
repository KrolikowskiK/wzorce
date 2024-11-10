package com.example.payment.method;

public class MastercardPayment extends CardPayment {
    @Override
    protected void registerPayment() {
        System.out.println("Użyto karty Mastercard...");
    }
}
