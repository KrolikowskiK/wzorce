package com.example.payment.service;

import com.example.database.DBProxy;
import com.example.database.Database;
import com.example.payment.method.PaymentMethod;

public class PaymentService implements PaymentProcessor {
    private final Database dbHandle;
    private static PaymentService paymentService;

    private PaymentService() {
        dbHandle = new DBProxy();
    }

    @Override
    public void processPayment(PaymentMethod method, double amount) {
        dbHandle.executeQuery("INSERT INTO PAYMENTS ... VALUES ...");
        method.pay(amount);
    }

    public static PaymentService getPaymentService() {
        if (paymentService == null) {
            paymentService = new PaymentService();
        }
        return paymentService;
    }
}
