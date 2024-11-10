package com.example.order.service;

import com.example.order.creator.Order;

public interface OrderProcessor {
    void processOrder(Order order, OrderDiscountApplier discountApplier);
}
