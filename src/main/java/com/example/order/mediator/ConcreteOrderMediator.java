package com.example.order.mediator;

import com.example.cart.Cart;
import com.example.inventory.Inventory;
import com.example.payment.strategy.PaymentStrategy;

public class ConcreteOrderMediator implements OrderMediator {
    private Cart cart;
    private Inventory inventory;
    private PaymentStrategy payment;

    public ConcreteOrderMediator(Cart cart, Inventory inventory, PaymentStrategy payment) {
        this.cart = cart;
        this.inventory = inventory;
        this.payment = payment;
    }

    @Override
    public void validateCart() {
        cart.validateItems();
    }

    @Override
    public boolean checkInventory() {
        return inventory.checkAvailability(cart);
    }

    @Override
    public void processPayment() {
        if (cart.isValid() && this.checkInventory()) {
            payment.pay(cart.getTotalAmount());
        }
    }
}
