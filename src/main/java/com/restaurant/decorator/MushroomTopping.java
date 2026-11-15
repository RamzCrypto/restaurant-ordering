package com.restaurant.decorator;

import com.restaurant.model.MenuItem;

public class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(MenuItem wrapped) { super(wrapped); }

    @Override protected String getToppingName() { return "Mushrooms"; }
    @Override protected double getToppingPrice() { return 1.20; }
}