package com.restaurant.command;

import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;

public class CancelOrderCommand implements Command {
    private final Order order;

    public CancelOrderCommand(Order order) { this.order = order; }

    @Override
    public void execute() {
        order.setStatus(OrderStatus.CANCELLED);
        System.out.println("[COMMAND] Order cancelled.");
    }
}