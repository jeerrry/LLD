package org.lld.coffeevendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Machine {
    private Map<Ingrediant, Integer> ingrediants = new ConcurrentHashMap<>();
    private final List<Coffee> coffees = new ArrayList<>();

    private double payment;
    private Coffee selectedCoffee;
    private MachineState currentState;
    private MachineState idleState;
    private MachineState readyState;
    private MachineState dispenseState;

    public Machine() {
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);

        currentState = idleState;
        selectedCoffee = null;
        payment = 0;
    }

    public synchronized void updateIngrediants(Ingrediant ingrediant, int quantity) {
        if (ingrediants.containsKey(ingrediant)) {
            ingrediants.put(ingrediant, quantity + ingrediants.get(ingrediant));
            return;
        }

        ingrediants.put(ingrediant, quantity);
    }

    public int getIngredientQuantity(Ingrediant ingrediant) {
        return ingrediants.getOrDefault(ingrediant, 0);
    }

    public void displayCoffeeMenu() {
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setSelectedCoffee(Coffee selectedCoffee) {
        this.selectedCoffee = selectedCoffee;
    }

    public void updateState(MachineState targetState) {
        currentState = targetState;
    }

    public MachineState getIdleState() {
        return idleState;
    }

    public MachineState getReadyState() {
        return readyState;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public MachineState getDispenseState() {
        return dispenseState;
    }
}
