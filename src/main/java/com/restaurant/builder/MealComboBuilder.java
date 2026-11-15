package com.restaurant.builder;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Order;

public class MealComboBuilder implements OrderBuilder {
    private final Order order = new Order();

    @Override
    public OrderBuilder addMainCourse(MenuItem main) {
        order.addItem(main);
        return this;
    }

    @Override
    public OrderBuilder addDrink(MenuItem drink) {
        order.addItem(drink);
        return this;
    }

    @Override
    public OrderBuilder addDessert(MenuItem dessert) {
        order.addItem(dessert);
        return this;
    }

    @Override
    public Order build() {
        if (order.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot build empty combo");
        }
        return order;
    }
}