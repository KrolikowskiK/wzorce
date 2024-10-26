package com.example;

import com.example.database.DBProxy;
import com.example.item.Item;
import com.example.item.Package;
import com.example.item.Product;
import com.example.order.Order;
import com.example.order.creator.ExpressOrderCreator;
import com.example.order.creator.OrderCreator;
import com.example.order.creator.PickupOrderCreator;
import com.example.order.decorator.DiscountDecorator;
import com.example.order.decorator.GiftWrappingDecorator;
import com.example.order.decorator.ShippingInsuranceDecorator;
import com.example.payment.service.PaymentAdapter;

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

        makeOrder(compositeItem, "express", "paypal", new String[] { "shippingInsurance" });
        makeOrder(compositeItem, "pickup", "card", new String[] { "giftWrapping", "discount" });

        new DBProxy().printDbLogs();
    }

    public static void makeOrder(Item item, String type, String paymentType, String[] decorators) {
        ArrayList<UnaryOperator<Order>> decoratorFunctions = new ArrayList<UnaryOperator<Order>>();
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
            OrderCreator creator = new ExpressOrderCreator();
            creator.processOrder(item, decoratorFunctions, paymentType);
        }
        if (type.equals("pickup")) {
            OrderCreator creator = new PickupOrderCreator();
            creator.processOrder(item, decoratorFunctions, paymentType);
        }
        System.out.println();
    }
}