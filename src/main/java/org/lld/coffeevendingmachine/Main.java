package org.lld.coffeevendingmachine;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var sugar = new Ingrediant("Sugar");
        var milk = new Ingrediant("Milk");
        var bean = new Ingrediant("Bean");

        var expresso = new Coffee("Expresso", 2, Arrays.asList(new Coffee.Items(sugar, 1), new Coffee.Items(milk, 0), new Coffee.Items(bean, 4)));
        var latte = new Coffee("Late", 5, Arrays.asList(new Coffee.Items(sugar, 2), new Coffee.Items(milk, 6), new Coffee.Items(bean, 3)));

        var machine = new Machine();
        machine.addCoffeeToMenu(expresso);
        machine.addCoffeeToMenu(latte);

        machine.updateIngrediants(sugar, 5);
        machine.updateIngrediants(milk, 10);
        machine.updateIngrediants(bean, 15);

        machine.displayCoffeeMenu();
        machine.selectCoffee(expresso);
        machine.makePayment(1);
        machine.makePayment(1);
        machine.getCoffeeWithChange();
    }
}
