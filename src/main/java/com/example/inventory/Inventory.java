package com.example.inventory;

import com.example.cart.Cart;
import com.example.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inventory {
    private List<Item> availableItems = new ArrayList<>();

    public boolean checkAvailability(Cart cart) {
        return new Random().nextBoolean();
    }

    public void addItem(Item item) {
        this.availableItems.add(item);
    }

    public List<Item> getItems() {
        return this.availableItems;
    }
}
