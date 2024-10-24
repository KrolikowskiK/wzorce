package com.example.payment;

public class PaymentAdapter implements PaymentProcessor {
    private ExternalPaymentService externalService;

    public PaymentAdapter(ExternalPaymentService externalService) {
        this.externalService = externalService;
    }

    private double transform(double amount) {
        System.out.println("Make transformation...");
        return amount;
    }

    @Override
    public void processPayment(double amount) {
        double transformedAmount = transform(amount);
        externalService.makePayment(transformedAmount);
    }
}
