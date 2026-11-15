package com.restaurant.decorator;

import com.restaurant.model.MenuItem;

public class BaconTopping extends ToppingDecorator {
    public BaconTopping(MenuItem wrapped) { super(wrapped); }

    @Override protected String getToppingName() { return "Bacon"; }
    @Override protected double getToppingPrice() { return 2.00; }
}