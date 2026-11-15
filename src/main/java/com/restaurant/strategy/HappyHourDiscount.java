package com.restaurant.strategy;

public class HappyHourDiscount implements DiscountStrategy {
    @Override
    public double apply(double subtotal) {
        return subtotal * 0.70; // 30% off
    }
}