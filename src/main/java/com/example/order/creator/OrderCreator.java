package com.example.order.creator;

import com.example.database.DBProxy;
import com.example.database.Database;
import com.example.item.Item;
import com.example.order.Order;
import com.example.payment.strategy.CardPayment;
import com.example.payment.strategy.PaymentStrategy;
import com.example.payment.strategy.PaypalPayment;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public abstract class OrderCreator {
    private Database dbHandle;

    public OrderCreator() {
        this.dbHandle = new DBProxy();
    }

    public abstract Order createOrder();

    public void processOrder(Item item, ArrayList<UnaryOperator<Order>> decorators, String paymentType) {
        Order order = createOrder();
        for (UnaryOperator<Order> decorator : decorators) {
            order = decorator.apply(order);
        }
        String details = order.getOrderDetails();
        String deliveryTime = order.getDeliveryTime();

        double total = order.getTotal(item);
        PaymentStrategy ps;
        if (paymentType.equals("card"))
            ps = new CardPayment();
        else
            ps = new PaypalPayment();

        order.setPaymentStrategy(ps);
        order.pay(total);

        dbHandle.executeQuery("INSERT INTO ORDERS ... VALUES ...");
        System.out.println(details + " " + deliveryTime + " " + total);
    }
}
