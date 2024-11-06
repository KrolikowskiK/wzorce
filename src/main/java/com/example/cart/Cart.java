package com.example.cart;

import com.example.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cart {
    private List<Item> itemList = new ArrayList<>();
    private boolean isValid;

    public void validateItems() {
        this.isValid = new Random().nextBoolean();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public double getTotalAmount() {
        return itemList.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public List<Item> getItems() {
        return this.itemList;
    }
}
