package com.example;

import com.example.authenticator.method.FingerprintAuthenticator;
import com.example.authenticator.service.AuthenticatorService;
import com.example.cart.Cart;
import com.example.item.Product;
import com.example.order.creator.Order;
import com.example.order.creator.OrderCreator;
import com.example.order.service.OrderService;
import com.example.user.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AuthenticatorService authenticatorService = new AuthenticatorService();
        OrderService orderService = new OrderService();

        User user1 = new User("Kacper", new FingerprintAuthenticator());
        authenticatorService.authenticate(user1);

        Cart user1Cart = user1.getCart()
                .addProduct(new Product("car seat"))
                .addProduct(new Product("engine oil"))
                .addProduct(new Product("camshaft"));

        OrderCreator orderCreator = new OrderCreator(user1, new ArrayList<>(user1Cart.getProducts()));
        try {
            orderCreator.setDeliverer("dpd");
            orderCreator.setPaymentMethod("visa");
            orderCreator.addNotificationChannel("push");
            orderCreator.addModifier("discount");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Order order1 = orderCreator.getOrder();
        orderService.processOrder(order1);
    }
}