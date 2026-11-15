package com.restaurant;

import com.restaurant.builder.MealComboBuilder;
import com.restaurant.command.*;
import com.restaurant.decorator.*;
import com.restaurant.factory.*;
import com.restaurant.model.*;
import com.restaurant.observer.*;
import com.restaurant.strategy.*;

public class Main {
    public static void main(String[] args) {
        // 1. FACTORY: создаём блюда
        MenuItemFactory pizzaFactory = new PizzaFactory();
        MenuItemFactory drinkFactory = new DrinkFactory();

        MenuItem pizza = pizzaFactory.createItem("margherita");
        MenuItem cola = drinkFactory.createItem("cola");

        // 2. DECORATOR: добавляем топпинги
        pizza = new CheeseTopping(pizza);
        pizza = new BaconTopping(pizza);

        // 3. BUILDER: собираем комбо
        Order order = new MealComboBuilder()
                .addMainCourse(pizza)
                .addDrink(cola)
                .build();

        // 4. STRATEGY: выбираем скидку
        order.setDiscountStrategy(new StudentDiscount());

        // 5. OBSERVER: подписываем кухню и клиента
        order.attach(new KitchenDisplay());
        order.attach(new CustomerNotifier());

        // 6. COMMAND: размещаем заказ через инвокер
        OrderInvoker invoker = new OrderInvoker();
        invoker.setCommand(new PlaceOrderCommand(order));
        invoker.executeCommand();

        // Меняем статус — Observer сработает автоматически
        order.setStatus(OrderStatus.READY);

        // Отмена через Command
        invoker.setCommand(new CancelOrderCommand(order));
        invoker.executeCommand();

        System.out.println("\nFinal total: $" + order.getTotal());
    }
}