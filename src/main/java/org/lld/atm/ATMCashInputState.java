package org.lld.atm;

public class ATMCashInputState implements MachineState {
    private ATM atm;

    public ATMCashInputState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void readyState(Card card) {
        System.out.println("Invalid Request");
    }

    @Override
    public void targetAmount(double amount) {
        if(atm.getCurrentState() != atm.cashInputState) {
            System.out.println("Invalid Request");
            return;
        }

        if (atm.getCurrentAccount().getBalance() < amount) {
            System.out.println("Insufficient Balance");
            return;
        }

        atm.setCurrentTransaction(new DebitTransaction(atm.getCurrentAccount(), amount));
        atm.setCurrentState(atm.cashCollectState);
    }

    @Override
    public void collectCash() {
        System.out.println("Invalid Request");
    }

    @Override
    public void collectReceipt() {
        System.out.println("Invalid Request");
    }
}
