package com.example.item;

import java.util.Random;

public class Product implements Item {
    private double price;

    public Product() {
        price = new Random().nextDouble() * 10;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
