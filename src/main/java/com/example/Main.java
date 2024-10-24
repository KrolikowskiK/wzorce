package com.example;

import com.example.order.ExpressOrderCreator;
import com.example.order.OrderCreator;
import com.example.order.PickupOrderCreator;
import com.example.payment.ExternalPaymentService;
import com.example.payment.PaymentAdapter;
import com.example.payment.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        ExternalPaymentService paymentService = new ExternalPaymentService();
        PaymentAdapter adapter = new PaymentAdapter(paymentService);

        makeOrder("express", adapter);
        makeOrder("pickup", adapter);
    }

    public static void makeOrder(String type, PaymentProcessor pp) {
        if (type.equals("express")) {
            OrderCreator creator = new ExpressOrderCreator();
            creator.processOrder(pp);
        }
        if (type.equals("pickup")) {
            OrderCreator creator = new PickupOrderCreator();
            creator.processOrder(pp);
        }
    }
}