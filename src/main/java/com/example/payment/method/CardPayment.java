package com.example.payment.method;

public abstract class CardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        this.registerPayment();
        System.out.println("Płatność kartą: " + amount);
        // dalsza logika płatności
    }

    // logic for different card providers
    protected abstract void registerPayment();
}