package com.example.order;

public abstract class OrderCreator {

    public abstract Order createOrder();

    public void processOrder() {
        Order order = createOrder();
        String details = order.getOrderDetails();
        String deliveryTime = order.getDeliveryTime();
        double total = order.getTotal();
        System.out.println(details + deliveryTime + total);
    }
}
