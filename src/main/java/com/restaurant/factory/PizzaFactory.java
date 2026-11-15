package com.restaurant.factory;

import com.restaurant.model.MenuItem;

public class PizzaFactory implements MenuItemFactory {
    @Override
    public MenuItem createItem(String type) {
        return switch (type.toLowerCase()) {
            case "margherita" -> new MenuItem() {
                public String getName() { return "Margherita Pizza"; }
                public double getPrice() { return 8.50; }
            };
            case "pepperoni" -> new MenuItem() {
                public String getName() { return "Pepperoni Pizza"; }
                public double getPrice() { return 10.00; }
            };
            default -> throw new IllegalArgumentException("Unknown pizza: " + type);
        };
    }
}