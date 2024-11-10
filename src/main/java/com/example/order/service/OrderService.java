package com.example.order.service;

import com.example.notification.NotificationSender;
import com.example.notification.NotificationService;
import com.example.order.creator.Describer;
import com.example.order.creator.Order;
import com.example.order.delivery.DeliveryService;
import com.example.order.service.interfaces.*;

import java.util.function.UnaryOperator;

public class OrderService implements OrderProcessor, OrderReturner, OrderCanceler, SurveySender, OrderTracker {
    private final DeliveryService deliveryService = new DeliveryService();
    private final NotificationService notificationService = new NotificationService();

    @Override
    public void processOrder(Order order, OrderDiscountApplier discountApplier) {

        Describer modifiedOrder = order;
        for (UnaryOperator<Describer> modifier : order.getModifiers())
            modifiedOrder = modifier.apply(order);

        double total = modifiedOrder.getTotal();
        System.out.println("Total: " + total);

        double discounted = total - discountApplier.apply(total);
        order.pay(discounted);
        for (NotificationSender notificator : order.getNotifiers()) {
            notificationService.notifyCustomer("Zapłacono: " + discounted, notificator);
        }

        deliveryService.commissionDelivery(order.getOrderId(), order.getDeliverer());
    }

    @Override
    public void cancelOrder(String orderId) throws IllegalStateException {
        // order not found in database...
        if (true) {
            throw new IllegalStateException("Order not found");
        }
    }

    @Override
    public void trackOrder(String orderId) {

    }

    @Override
    public void sendCustomerSurvey(String orderId) {

    }

    @Override
    public void returnOrder(String orderId) throws IllegalArgumentException {
        if (orderId == null)
            throw new IllegalArgumentException("Order ID cannot be null");
    }
}
