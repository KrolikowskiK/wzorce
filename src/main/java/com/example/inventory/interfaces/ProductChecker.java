package com.example.inventory.interfaces;

import com.example.item.Product;

public interface ProductChecker {
    boolean checkProductAvailability(Product p, int count);
}
