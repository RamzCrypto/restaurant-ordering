package com.restaurant.command;

import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;

public class PlaceOrderCommand implements Command {
    private final Order order;

    public PlaceOrderCommand(Order order) { this.order = order; }

    @Override
    public void execute() {
        order.setStatus(OrderStatus.PREPARING);
        System.out.println("[COMMAND] Order placed. Total: $" + order.getTotal());
    }
}