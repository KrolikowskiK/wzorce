package com.example.order;

import com.example.item.Item;

public interface Order {
    public double getTotal(Item item);
    public String getOrderDetails();
    public String getDeliveryTime();
}
