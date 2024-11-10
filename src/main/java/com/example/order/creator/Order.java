package com.example.order.creator;

import com.example.item.Item;
import com.example.notification.NotificationSender;
import com.example.order.delivery.Deliverer;
import com.example.payment.method.PaymentMethod;
import com.example.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Order implements Describer {
    private String orderId;
    protected User user;
    protected List<Item> items;
    protected Deliverer deliverer;
    protected PaymentMethod paymentMethod;
    protected List<NotificationSender> notifiers = new ArrayList<>();
    protected List<UnaryOperator<Describer>> modifiers = new ArrayList<>();

    public Order(User user, List<Item> items) {
        this.orderId = String.valueOf(new Random().nextInt() & Integer.MAX_VALUE);
        this.user = user;
        this.items = items;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void addNotifier(NotificationSender notifier) {
        this.notifiers.add(notifier);
    }

    public List<NotificationSender> getNotifiers() {
        return this.notifiers;
    }

    public Deliverer getDeliverer() {
        return this.deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    public void addModifier(UnaryOperator<Describer> modifier) {
        this.modifiers.add(modifier);
    }

    public List<UnaryOperator<Describer>> getModifiers() {
        return this.modifiers;
    }

    public void setPaymentStrategy(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double amount) {
        this.paymentMethod.pay(amount);
    }

    @Override
    public double getTotal() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
    }

    @Override
    public String getOrderDetails() {
        return "Basic order";
    }
}
