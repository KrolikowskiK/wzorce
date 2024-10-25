package com.example;

import com.example.database.DBProxy;
import com.example.item.Item;
import com.example.item.Package;
import com.example.item.Product;
import com.example.order.ExpressOrderCreator;
import com.example.order.OrderCreator;
import com.example.order.PickupOrderCreator;
import com.example.payment.ExternalPaymentService;
import com.example.payment.PaymentAdapter;
import com.example.payment.PaymentProcessor;

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

        makeOrder("express", compositeItem, adapter);
        makeOrder("pickup", compositeItem, adapter);

        new DBProxy().printDbLogs();
    }

    public static void makeOrder(String type, Item item, PaymentProcessor pp) {
        if (type.equals("express")) {
            OrderCreator creator = new ExpressOrderCreator(pp);
            creator.processOrder(item);
        }
        if (type.equals("pickup")) {
            OrderCreator creator = new PickupOrderCreator(pp);
            creator.processOrder(item);
        }
    }
}