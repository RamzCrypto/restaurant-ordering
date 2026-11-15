package com.restaurant.factory;

import com.restaurant.model.MenuItem;

public class BurgerFactory implements MenuItemFactory {
    @Override
    public MenuItem createItem(String type) {
        return switch (type.toLowerCase()) {
            case "classic" -> new MenuItem() {
                public String getName() { return "Classic Burger"; }
                public double getPrice() { return 6.00; }
            };
            case "cheeseburger" -> new MenuItem() {
                public String getName() { return "Cheeseburger"; }
                public double getPrice() { return 7.00; }
            };
            default -> throw new IllegalArgumentException("Unknown burger: " + type);
        };
    }
}