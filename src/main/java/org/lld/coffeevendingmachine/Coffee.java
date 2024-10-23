package org.lld.coffeevendingmachine;

import java.util.List;

public class Coffee {
    private final String name;
    private final double price;
    private final List<Items> requiredIngredients;

    public record Items(Ingrediant ingrediant, int quantity) {}

    public Coffee(final String name, double price, List<Items> requiredIngredients) {
        this.name = name;
        this.price = price;
        this.requiredIngredients = requiredIngredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<Items> getIngrediants() {
        return requiredIngredients;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
