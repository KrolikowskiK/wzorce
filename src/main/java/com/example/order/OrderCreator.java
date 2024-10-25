package com.example.order;

import com.example.database.DBProxy;
import com.example.database.Database;
import com.example.item.Item;
import com.example.payment.PaymentProcessor;

public abstract class OrderCreator {
    private PaymentProcessor pp;
    private Database dbHandle;

    public OrderCreator(PaymentProcessor pp) {
        this.pp = pp;
        this.dbHandle = new DBProxy();
    }

    public abstract Order createOrder();

    public void processOrder(Item item) {
        Order order = createOrder();
        String details = order.getOrderDetails();
        String deliveryTime = order.getDeliveryTime();
        double total = order.getTotal(item);
        pp.processPayment(total);
        dbHandle.executeQuery("INSERT INTO PAYMENTS ... VALUES ...");
        System.out.println(details + " " + deliveryTime + " " + total);
    }
}
