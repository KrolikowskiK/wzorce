package com.example;

import com.example.database.DBProxy;
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

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Item compositeItem = new Package(
            new Item[] {
                new Product(),
                new Package(new Item[] { new Product(), new Product() } )
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