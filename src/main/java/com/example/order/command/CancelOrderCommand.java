package com.example.order.command;

import com.example.order.Order;

public class CancelOrderCommand implements OrderCommand {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("Anulowano zamówienie: " + order.getOrderDetails());
    }
}