package org.lld.coffeevendingmachine;


public class IdleState implements MachineState {
    private Machine machine;

    public IdleState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void selectCoffee(Coffee coffee) {
        var ingrediants = coffee.getIngrediants();
        for(var ingredient : ingrediants) {
            if(machine.getIngredientQuantity(ingredient.ingrediant()) < ingredient.quantity()) {
                System.out.println("Insufficient Ingredient Quantity");
                return;
            }
        }

        machine.setSelectedCoffee(coffee);
        machine.updateState(machine.getReadyState());
    }

    @Override
    public void acceptPayment(double payment) {
        System.out.println("Select a product first");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Select a product first");
    }
}
