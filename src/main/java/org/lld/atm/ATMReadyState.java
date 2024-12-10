package org.lld.atm;

public class ATMReadyState implements MachineState {
    private ATM atm;

    public ATMReadyState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void readyState(Card card) {
        var account = atm.getBankingService().getAccountByCard(card);
        if (account == null) {
            System.out.println("Invalid card!");
            return;
        }

        atm.setCurrentAccount(account);
        System.out.println("Welcome " + account.getUsername());
        System.out.println("Please enter your amount!");
        atm.setCurrentState(atm.cashInputState);
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
        System.out.println("Invalid Request");
    }
}
