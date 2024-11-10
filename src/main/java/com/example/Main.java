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
    static double DISCOUNT_THRESHOLD = 100;

    public static void main(String[] args) {
        AuthenticatorService authenticatorService = new AuthenticatorService();
        OrderService orderService = new OrderService();

        OrderDiscountApplier discountApplier = (amount) -> {
            // 10% zniżki przy kwocie powyżej DISCOUNT_TRESHOLD
            double discount = amount > DISCOUNT_THRESHOLD ? 0.1 * amount : 0;
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

/*
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Cart cart1 = new Cart();
        cart1.addProduct(new Product("car seat"));
        cart1.addProduct(new Product("engine oil"));
        cart1.addProduct(new Product("camshaft"));
        System.out.println("Wartość koszyka: " + cart1.getTotalAmount());
        CartMemento cart1Memento = cart1.save();
        cart1.removeProduct("camshaft");
        System.out.println("Wartość koszyka: " + cart1.getTotalAmount());
        cart1.restore(cart1Memento);
        System.out.println("Wartość koszyka: " + cart1.getTotalAmount());

        Cart cart2 = new DiscountedCart(10);
        cart2.addProduct(new Product("orange"));
        cart2.addProduct(new Product("banana"));
        System.out.println("Wartość koszyka z raabatem: " + cart2.getTotalAmount());

        NotificationSender notification = new EmailNotificationSender();
        System.out.println(notification.sendNotification("Promocja 20%!"));
        notification = new SMSNotificationSender();
        System.out.println(notification.sendNotification("Promocja 20%!"));

        UserAuthenticator authenticator = new PasswordAuthenticator();
        System.out.println("Autoryzacja hasłem: " + authenticator.authenticate("Jan"));
        authenticator = new BiometricAuthenticator();
        System.out.println("Autoryzacja biometryczna: " + authenticator.authenticate("Jan"));

        OrderMediator orderMediator = new ConcreteOrderMediator(cart1, inventory, new CardPayment());
        orderMediator.validateCart();
        orderMediator.checkInventory();
        orderMediator.processPayment();

        Item compositeItem = new Package(
            new Item[] {
                new Product("shoes"),
                new Package(new Item[] { new Product("butter"), new Product("toothpaste") } )
            }
        );

        OrderInvoker orderInvoker = new OrderInvoker();

        makeOrder(compositeItem, "express", "paypal", new String[] { "shippingInsurance" }, orderInvoker);
        makeOrder(compositeItem, "pickup", "card", new String[] { "giftWrapping", "discount" }, orderInvoker);

        new DBProxy().printDbLogs();
    }

    public static void makeOrder(Item item, String type, String paymentType, String[] decorators, OrderInvoker orderInvoker) {
        ArrayList<UnaryOperator<Order>> decoratorFunctions = new ArrayList<>();
        for (String decoName : decorators) {
            if (decoName.equals("shippingInsurance")) {
                decoratorFunctions.add(ShippingInsuranceDecorator::new);
            }
            if (decoName.equals("giftWrapping")) {
                decoratorFunctions.add(GiftWrappingDecorator::new);
            }
            if (decoName.equals("discount")) {
                decoratorFunctions.add(a -> new DiscountDecorator(a, 10));
            }
        }

        if (type.equals("express")) {
            OrderCreator creator = new ExpressOrderCreator(orderInvoker);
            creator.processOrder(item, decoratorFunctions, paymentType);
        }
        if (type.equals("pickup")) {
            OrderCreator creator = new PickupOrderCreator(orderInvoker);
            creator.processOrder(item, decoratorFunctions, paymentType);
        }
        System.out.println();
    }
}
*/