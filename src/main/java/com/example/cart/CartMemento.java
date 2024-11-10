package com.example.cart;

import com.example.item.Product;

import java.util.ArrayList;
import java.util.List;

public class CartMemento {
    private final List<Product> products;

    public CartMemento(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public List<Product> getProducts() {
        return products;
    }
}
