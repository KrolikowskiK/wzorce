package com.example.order.service;
@FunctionalInterface
public interface OrderDiscountApplier {
    double apply(double amount);
}
