package com.example.order;

import com.example.item.Item;
import com.example.payment.PaymentProcessor;

public abstract class OrderCreator {

    public abstract Order createOrder();

    public void processOrder(Item item, PaymentProcessor pp) {
        Order order = createOrder();
        String details = order.getOrderDetails();
        String deliveryTime = order.getDeliveryTime();
        double total = order.getTotal(item);
        pp.processPayment(total);
        System.out.println(details + " " + deliveryTime + " " + total);
    }
}
