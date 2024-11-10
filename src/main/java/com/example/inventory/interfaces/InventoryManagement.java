package com.example.inventory.interfaces;

import com.example.item.Product;

import java.util.List;

public interface InventoryManagement {
    boolean checkProductAvailability(Product p, int count);
    double getStorageAvailableSpace();
    List<Product> getAllProducts();
    List<Product> getProductsOlderThan(String date);
}
