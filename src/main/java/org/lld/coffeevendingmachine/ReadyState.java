package org.lld.coffeevendingmachine;

public class ReadyState implements MachineState{
    private Machine machine;

    public ReadyState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void selectCoffee(Coffee coffee) {
        System.out.println("Product already selected");
    }

    @Override
    public void acceptPayment(double payment) {
        machine.setPayment(payment + machine.getPayment());
        double totalPayment = machine.getPayment();
        double requiredPayment = machine.getSelectedCoffee().getPrice();
        if(totalPayment > requiredPayment){
            machine.setPayment(totalPayment - requiredPayment);
            System.out.println("Payment made, please get your coffee and change...!");
            machine.updateState(machine.getDispenseState());

            return;
        }

        if(totalPayment < requiredPayment){
            double shortAmount = totalPayment - requiredPayment;
            System.out.println("Please insert "+shortAmount+"$ more for completing order...!");
            return;
        }

        System.out.println("Payment made, please get your coffee...!");
        machine.setPayment(0);
        machine.updateState(machine.getDispenseState());
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Make payment first");
    }
}
