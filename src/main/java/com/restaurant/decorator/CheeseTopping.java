package com.restaurant.decorator;

import com.restaurant.model.MenuItem;

public class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(MenuItem wrapped) { super(wrapped); }

    @Override protected String getToppingName() { return "Cheese"; }
    @Override protected double getToppingPrice() { return 1.50; }
}