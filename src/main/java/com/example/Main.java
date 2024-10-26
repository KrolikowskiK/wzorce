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
import com.example.payment.ExternalPaymentService;
import com.example.payment.PaymentAdapter;
import com.example.payment.PaymentProcessor;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        ExternalPaymentService paymentService = new ExternalPaymentService();
        PaymentAdapter adapter = new PaymentAdapter(paymentService);

        Item compositeItem = new Package(
            new Item[] {
                new Product(),
                new Package(new Item[] { new Product(), new Product() } )
            }
        );

        makeOrder("express", compositeItem, adapter, new String[] { "shippingInsurance" });
        makeOrder("pickup", compositeItem, adapter, new String[] { "giftWrapping", "discount" });

        new DBProxy().printDbLogs();
    }

    public static void makeOrder(String type, Item item, PaymentProcessor pp, String[] decorators) {
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
            OrderCreator creator = new ExpressOrderCreator(pp);
            creator.processOrder(item, decoratorFunctions);
        }
        if (type.equals("pickup")) {
            OrderCreator creator = new PickupOrderCreator(pp);
            creator.processOrder(item, decoratorFunctions);
        }
    }
}