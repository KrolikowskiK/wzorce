package com.example.order.command;

import com.example.order.Order;

public class AddOrderCommand implements OrderCommand {
    private Order order;

    public AddOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("Dodano zamówienie: " + order.getOrderDetails());
    }
}