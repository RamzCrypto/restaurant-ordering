package com.restaurant.observer;

import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;

public interface OrderObserver {
    void update(Order order, OrderStatus newStatus);
}