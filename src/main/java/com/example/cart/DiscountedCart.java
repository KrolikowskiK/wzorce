package com.example.cart;

public class DiscountedCart extends Cart {
    private final double discountPercentage;

    public DiscountedCart(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getTotalAmount() {
        double cartTotal = super.getTotalAmount();
        return cartTotal - (cartTotal * discountPercentage / 100);
    }
}
