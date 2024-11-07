package com.example;

import com.example.cart.Cart;
import com.example.cart.CartMemento;
import com.example.database.DBProxy;
import com.example.inventory.Inventory;
import com.example.item.Item;
import com.example.item.Package;
import com.example.item.Product;
import com.example.order.Order;
import com.example.order.command.OrderInvoker;
import com.example.order.creator.ExpressOrderCreator;
import com.example.order.creator.OrderCreator;
import com.example.order.creator.PickupOrderCreator;
import com.example.order.decorator.DiscountDecorator;
import com.example.order.decorator.GiftWrappingDecorator;
import com.example.order.decorator.ShippingInsuranceDecorator;
import com.example.order.mediator.ConcreteOrderMediator;
import com.example.order.mediator.OrderMediator;
import com.example.payment.strategy.CardPayment;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

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