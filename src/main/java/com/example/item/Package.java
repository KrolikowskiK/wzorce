package com.example.item;

import java.util.Arrays;
import java.util.Random;

public class Package implements Item {
    private double price;
    private Item[] items;

    public Package(Item[] items) {
        price = new Random().nextDouble() * 5;
        this.items = items;
    }

    @Override
    public double getPrice() {
        return Arrays.stream(items).reduce(0.0, (sum, item) -> sum + item.getPrice(), Double::sum) + price;
    }
}
