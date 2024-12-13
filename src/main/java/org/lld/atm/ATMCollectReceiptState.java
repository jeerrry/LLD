package org.lld.atm;

public class ATMCollectReceiptState implements MachineState {
    private ATM atm;

    public ATMCollectReceiptState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void readyState(Card card) {
        System.out.println("Invalid Request");
    }

    @Override
    public void targetAmount(double amount) {
        System.out.println("Invalid Request");
    }

    @Override
    public void collectCash() {
        System.out.println("Invalid Request");
    }

    @Override
    public void collectReceipt() {
        if (atm.getCurrentState() != atm.collectReceiptState) {
            System.out.println("Invalid Request");
            return;
        }

        System.out.println("Receipt collected!");
        atm.setCurrentState(atm.readyState);
    }
}
