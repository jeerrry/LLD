package org.lld.coffeevendingmachine;

public class DispenseState implements MachineState {
    private Machine machine;

    public DispenseState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void selectCoffee(Coffee coffee) {
        System.out.println("Collect coffee and if any change first");
    }

    @Override
    public void acceptPayment(double payment) {
        System.out.println("Payment already made");
    }

    @Override
    public void dispenseCoffee() {
        var ingrediants = machine.getSelectedCoffee().getIngrediants();
        for (var ingredient : ingrediants) {
            int currentQuantity = machine.getIngredientQuantity(ingredient.ingrediant());
            int left = currentQuantity - ingredient.quantity();
            machine.updateIngrediants(ingredient.ingrediant(), -left);
        }

        System.out.println("Here is your coffee and change...!");
        System.out.println("Coffee:" + machine.getSelectedCoffee());
        if (machine.getPayment() > 0)
            System.out.println("Change:" + machine.getPayment());

        machine.setSelectedCoffee(null);
        machine.setPayment(0);

        machine.updateState(machine.getIdleState());
    }
}
