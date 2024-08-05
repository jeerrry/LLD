package org.lld.vendingmachine;

import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final ConcurrentHashMap<Product, Integer> inventory;

    public Inventory() {
        inventory = new ConcurrentHashMap<>();
    }

    public void addProduct(Product p, int quantity) {
        updateQuantity(p, quantity);
    }

    public void removeProduct(Product p) {
        if (!isAvailable(p)) return;

        inventory.remove(p);
    }

    public void updateQuantity(Product p, int quantity) {
        int currentQuantity = inventory.getOrDefault(p, 0);
        inventory.put(p, currentQuantity + quantity);
    }

    public int getQuantity(Product p) {
        return isAvailable(p) ? inventory.get(p) : 0;
    }

    public boolean isAvailable(Product p) {
        return inventory.containsKey(p) && inventory.get(p) > 0;
    }
}
