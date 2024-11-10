package com.example.order.creator;

import com.example.item.Item;
import com.example.notification.method.EmailNotificationSender;
import com.example.notification.method.PushNotificationSender;
import com.example.notification.method.SMSNotificationSender;
import com.example.order.modifiers.DiscountModifier;
import com.example.order.modifiers.GiftWrappingModifier;
import com.example.order.modifiers.InsuranceModifier;
import com.example.order.delivery.method.DpdDelivery;
import com.example.order.delivery.method.InpostDelivery;
import com.example.order.delivery.method.ShopDelivery;
import com.example.payment.method.*;
import com.example.user.User;

import java.util.List;

public class OrderCreator {
    private final Order order;

    public OrderCreator(User user, List<Item> items) {
        this.order = new Order(user, items);
    }

    public void setPaymentMethod(String method) throws Exception {
        switch (method) {
            case "visa":
                order.setPaymentStrategy(new VisaPayment());
                break;
            case "mastercard":
                order.setPaymentStrategy(new MastercardPayment());
                break;
            case "paypal":
                order.setPaymentStrategy(new PaypalPayment());
                break;
            default:
                throw new Exception("Nieznana metoda płatności");
        }
    }

    public void setDeliverer(String name) throws Exception {
        switch (name) {
            case "dpd":
                order.setDeliverer(new DpdDelivery());
                break;
            case "inpost":
                order.setDeliverer(new InpostDelivery());
                break;
            case "shop":
                order.setDeliverer(new ShopDelivery());
                break;
            default:
                throw new Exception("Nieznany dostawca");
        }
    }

    public void addNotificationChannel(String name) throws Exception {
        switch (name) {
            case "email":
                order.addNotifier(new EmailNotificationSender());
                break;
            case "push":
                order.addNotifier(new PushNotificationSender());
                break;
            case "sms":
                order.addNotifier(new SMSNotificationSender());
                break;
            default:
                throw new Exception("Nieznana metoda powiadamiania");
        }
    }

    public void addModifier(String name) throws Exception {
        switch (name) {
            case "gift":
                order.addModifier(GiftWrappingModifier::new);
                break;
            case "discount":
                order.addModifier(DiscountModifier::new);
                break;
            case "insurance":
                order.addModifier(InsuranceModifier::new);
        }
    }

    public Order getOrder() {
        return this.order;
    }
}
