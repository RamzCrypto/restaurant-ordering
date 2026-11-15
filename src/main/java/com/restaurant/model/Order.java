package com.restaurant.model;

import com.restaurant.observer.OrderObserver;
import com.restaurant.strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> items = new ArrayList<>();
    private final List<OrderObserver> observers = new ArrayList<>();
    private DiscountStrategy discountStrategy;
    private OrderStatus status = OrderStatus.CREATED;

    public void addItem(MenuItem item) { items.add(item); }

    public double getSubtotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public double getTotal() {
        return discountStrategy != null
                ? discountStrategy.apply(getSubtotal())
                : getSubtotal();
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    // ===== OBSERVER: подписка и уведомление =====
    public void attach(OrderObserver observer) { observers.add(observer); }
    public void detach(OrderObserver observer) { observers.remove(observer); }

    public void setStatus(OrderStatus newStatus) {
        this.status = newStatus;
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver o : observers) {
            o.update(this, status);
        }
    }

    public OrderStatus getStatus() { return status; }
    public List<MenuItem> getItems() { return items; }
}