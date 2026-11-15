package com.restaurant.factory;

import com.restaurant.model.MenuItem;

public class DrinkFactory implements MenuItemFactory {
    @Override
    public MenuItem createItem(String type) {
        return switch (type.toLowerCase()) {
            case "cola" -> new MenuItem() {
                public String getName() { return "Cola"; }
                public double getPrice() { return 2.00; }
            };
            case "water" -> new MenuItem() {
                public String getName() { return "Water"; }
                public double getPrice() { return 1.00; }
            };
            default -> throw new IllegalArgumentException("Unknown drink: " + type);
        };
    }
}