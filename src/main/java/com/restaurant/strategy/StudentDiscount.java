package com.restaurant.strategy;

public class StudentDiscount implements DiscountStrategy {
    @Override
    public double apply(double subtotal) {
        return subtotal * 0.85; // 15% off
    }
}