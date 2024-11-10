package com.example.inventory.interfaces;

import com.example.item.Product;

import java.util.List;

public interface ProductOlderThanGetter {
    List<Product> getProductsOlderThan(String date);
}
