package com.example.payment.method;

public class VisaPayment extends CardPayment {
    @Override
    protected void registerPayment() {
        System.out.println("Użyto karty Visa...");
    }
}
