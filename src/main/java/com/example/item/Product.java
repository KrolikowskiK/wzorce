package com.example.item;

import java.util.Random;

public class Product implements Item {
    private String name;
    private double price;

    public Product(String name) {
        this.name = name;
        this.price = new Random().nextDouble(100, 300);
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
