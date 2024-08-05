package org.lld.vendingmachine;

public class ReadyState implements MachineState {
    private final Machine machine;

    public ReadyState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected!");
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addCoin(coin);
        System.out.println("Payment of amount " + machine.getTotalPayment() + " made");

        checkPayment();
    }

    @Override
    public void insertNote(Note note) {
        machine.addNote(note);
        System.out.println("Payment of amount " + machine.getTotalPayment() + " made");

        checkPayment();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Make Payment First");
    }

    @Override
    public void returnChange() {
        System.out.println("Make Payment First");
    }

    private void checkPayment() {
        if (machine.getTotalPayment() < machine.getSelectedProduct().getPrice()) return;
        System.out.println("Payment Complete");
        machine.setCurrentState(machine.getDispenseState());
    }
}
