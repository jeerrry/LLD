package org.lld.vendingmachine;

public class DispenseState implements MachineState{
    private Machine machine;

    public DispenseState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product selected already");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already made");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already made");
    }

    @Override
    public void dispenseProduct() {
        var product = machine.getSelectedProduct();
        machine.dispenseProduct(product);
        System.out.println("Product dispensed "+ product.getName());

        if(machine.getTotalPayment() > product.getPrice())
            machine.setCurrentState(machine.getReturnChangeState());
        else
            machine.setCurrentState(machine.getIdleState());
    }

    @Override
    public void returnChange() {
        System.out.println("Collect the dispensed product first");
    }
}
