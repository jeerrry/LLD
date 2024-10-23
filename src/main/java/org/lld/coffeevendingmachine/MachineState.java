package org.lld.coffeevendingmachine;

public interface MachineState {
    void selectCoffee(Coffee coffee);
    void acceptPayment(double payment);
    void dispenseCoffee();
}
