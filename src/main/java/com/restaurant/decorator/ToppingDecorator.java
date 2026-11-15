package com.restaurant.decorator;

import com.restaurant.model.MenuItem;

public abstract class ToppingDecorator implements MenuItem {
    protected final MenuItem wrapped;

    public ToppingDecorator(MenuItem wrapped) { this.wrapped = wrapped; }

    @Override
    public String getName() { return wrapped.getName() + " + " + getToppingName(); }

    @Override
    public double getPrice() { return wrapped.getPrice() + getToppingPrice(); }

    protected abstract String getToppingName();
    protected abstract double getToppingPrice();
}