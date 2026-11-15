package com.restaurant.observer;

import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;

public class KitchenDisplay implements OrderObserver {
    @Override
    public void update(Order order, OrderStatus newStatus) {
        System.out.println("[KITCHEN] Order status changed to: " + newStatus);
        if (newStatus == OrderStatus.CREATED) {
            System.out.println("[KITCHEN] Starting preparation...");
        }
    }
}