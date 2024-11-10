package com.example.inventory;

import com.example.cart.Cart;
import com.example.inventory.interfaces.ProductOlderThanGetter;
import com.example.inventory.interfaces.SpaceChecker;
import com.example.item.Item;
import com.example.item.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inventory implements SpaceChecker, ProductOlderThanGetter {
    private final List<Item> availableItems = new ArrayList<>();

    public boolean checkAvailability(Cart cart) {
        return new Random().nextBoolean();
    }

    public void addItem(Item item) {
        this.availableItems.add(item);
    }

    public List<Item> getItems() {
        return this.availableItems;
    }

    @Override
    public List<Product> getProductsOlderThan(String date) {
        return List.of();
    }

    @Override
    public double getStorageAvailableSpace() {
        return 0;
    }
}
