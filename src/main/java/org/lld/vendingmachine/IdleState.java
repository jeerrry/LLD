package org.lld.vendingmachine;

public class IdleState implements MachineState {
    private final Machine machine;

    public IdleState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        if (!machine.isAvailable(product)) {
            System.out.println("Selected product " + product.getName() + " is not available");
            return;
        }

        machine.selectProduct(product);
        machine.setCurrentState(machine.getReadyState());
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select a product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Select a product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select a product first and make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return");
    }
}
