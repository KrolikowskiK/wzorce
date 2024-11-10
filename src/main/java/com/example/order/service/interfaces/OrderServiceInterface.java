package com.example.order.service.interfaces;

import com.example.order.creator.Order;

public interface OrderServiceInterface {
    void processOrder(Order order);
    void cancelOrder(String orderId);
    void trackOrder(String orderId);
    void returnOrder(String orderId);
    void sendCustomerSurvey(String orderId);
}
