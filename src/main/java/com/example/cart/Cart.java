package com.example.cart;

import com.example.item.Item;
import com.example.item.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cart {
    private List<Product> products = new ArrayList<>();
    private boolean isValid;

    public void validateItems() {
        this.isValid = new Random().nextBoolean();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public double getTotalAmount() {
        return products.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productName) {
        products = products.stream()
                .filter((product) -> !product.getName().equals(productName))
                .collect(Collectors.toList());
    }

    public CartMemento save() {
        return new CartMemento(products);
    }

    public void restore(CartMemento memento) {
        products = memento.getProducts();
        System.out.println("Przywrócono stan koszyka");
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
