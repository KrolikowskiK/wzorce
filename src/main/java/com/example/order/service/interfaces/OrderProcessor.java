package com.example.order.service.interfaces;

import com.example.order.creator.Order;
import com.example.order.service.OrderDiscountApplier;

public interface OrderProcessor {
    void processOrder(Order order, OrderDiscountApplier discountApplier);
}
