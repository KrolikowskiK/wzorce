package com.example.order.creator;

import com.example.database.DBProxy;
import com.example.database.Database;
import com.example.item.Item;
import com.example.order.Order;
import com.example.payment.PaymentProcessor;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public abstract class OrderCreator {
    private PaymentProcessor pp;
    private Database dbHandle;

    public OrderCreator(PaymentProcessor pp) {
        this.pp = pp;
        this.dbHandle = new DBProxy();
    }

    public abstract Order createOrder();

    public void processOrder(Item item, ArrayList<UnaryOperator<Order>> decorators) {
        Order order = createOrder();
        for (UnaryOperator<Order> decorator : decorators) {
            order = decorator.apply(order);
        }
        String details = order.getOrderDetails();
        String deliveryTime = order.getDeliveryTime();
        double total = order.getTotal(item);
        pp.processPayment(total);
        dbHandle.executeQuery("INSERT INTO ORDERS ... VALUES ...");
        System.out.println(details + " " + deliveryTime + " " + total);
    }
}
