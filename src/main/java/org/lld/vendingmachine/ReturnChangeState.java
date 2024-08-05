package org.lld.vendingmachine;

public class ReturnChangeState implements MachineState {
    private final Machine machine;

    public ReturnChangeState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Collect change first");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Collect change first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Collect change first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Collect change first");
    }

    @Override
    public void returnChange() {
        double paid = machine.getTotalPayment();
        double real = machine.getSelectedProduct().getPrice();
        double change = paid - real;

        System.out.println("Collect change " + change);
        machine.setCurrentState(machine.getIdleState());
    }
}
