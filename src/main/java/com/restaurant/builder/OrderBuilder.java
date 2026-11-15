package com.restaurant.builder;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Order;

public interface OrderBuilder {
    OrderBuilder addMainCourse(MenuItem main);
    OrderBuilder addDrink(MenuItem drink);
    OrderBuilder addDessert(MenuItem dessert);
    Order build();
}