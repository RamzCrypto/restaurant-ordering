package com.restaurant.factory;

import com.restaurant.model.MenuItem;

public interface MenuItemFactory {
    MenuItem createItem(String type);
}