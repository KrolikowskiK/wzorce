package com.example.payment;

import com.example.database.DBProxy;
import com.example.database.Database;

// L1 start adapter, proxy
public class PaymentAdapter implements PaymentProcessor {
    private ExternalPaymentService externalService;
    private Database dbHandle;

    public PaymentAdapter(ExternalPaymentService externalService) {
        this.externalService = externalService;
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
}
