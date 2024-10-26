package com.example.payment.service;

import com.example.database.DBProxy;
import com.example.database.Database;

public class PaymentAdapter implements PaymentProcessor {
    private ExternalPaymentService externalService;
    private Database dbHandle;
    public static PaymentAdapter pa;

    private PaymentAdapter() {
        this.externalService = new ExternalPaymentService();
        dbHandle = new DBProxy();
    }

    private double transform(double amount) {
        System.out.println("Make transformation...");
        return amount;
    }

    @Override
    public void processPayment(double amount) {
        double transformedAmount = transform(amount);
        dbHandle.executeQuery("INSERT INTO PAYMENTS ... VALUES ...");
        externalService.makePayment(transformedAmount);
    }

    public static PaymentAdapter getPaymentAdapter() {
        if (pa == null) {
            pa = new PaymentAdapter();
        }
        return pa;
    }
}
