package com.example.order.service;

import com.example.order.creator.Order;

@FunctionalInterface
public interface OrderValidator {
    boolean validate(Order order);
}