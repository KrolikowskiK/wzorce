package com.example.order.service;

@FunctionalInterface
public interface OrderLogger {
    void log(String orderId, String message);
}
