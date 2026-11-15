package com.restaurant.observer;

import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;

public class CustomerNotifier implements OrderObserver {
    @Override
    public void update(Order order, OrderStatus newStatus) {
        System.out.println("[CUSTOMER] Your order is now: " + newStatus);
    }
}