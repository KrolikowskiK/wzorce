package com.example;

import com.example.authenticator.method.FingerprintAuthenticator;
import com.example.authenticator.AuthenticatorService;
import com.example.cart.Cart;
import com.example.item.Product;
import com.example.order.creator.Order;
import com.example.order.creator.OrderCreator;
import com.example.order.service.OrderDiscountApplier;
import com.example.order.service.OrderLogger;
import com.example.order.service.OrderService;
import com.example.order.service.OrderValidator;
import com.example.user.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AuthenticatorService authenticatorService = new AuthenticatorService();
        OrderService orderService = new OrderService();

        OrderDiscountApplier discountApplier = (amount) -> {
            // 10% zniżki przy kwocie powyżej 100
            double discount = amount > 100 ? 0.1 * amount : 0;
            if (discount > 0)
                System.out.println("Zastosowano zniżkę w wysokości " + discount);
            return discount;
        };

        OrderLogger orderLogger = (orderId, message) -> {
            System.out.println("Wiadomość dla zamówienia nr " + orderId);
            System.out.println(message);
        };

        OrderValidator orderValidator = (order) -> {
            order.getOrderId();
            // do some validation logic
            return true;
        };

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
        if (orderValidator.validate(order1)) {
            orderLogger.log(order1.getOrderId(), "Start przetwarzania zamówienia");
            orderService.processOrder(order1, discountApplier);
        }
    }
}