package com.example.order.service;

import com.example.notification.NotificationSender;
import com.example.notification.NotificationService;
import com.example.order.creator.Describer;
import com.example.order.creator.Order;
import com.example.order.delivery.DeliveryService;

import java.util.function.UnaryOperator;

public class OrderService implements OrderProcessor {
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
}
