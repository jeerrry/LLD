package org.lld.atm;

public class ATMCashCollectState implements MachineState {
    private ATM atm;

    public ATMCashCollectState(ATM atm) {
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
        if (atm.getCurrentState() != atm.cashCollectState) {
            System.out.println("Invalid Request");
            return;
        }

        atm.getCurrentTransaction().execute();
        System.out.println("Kindly collect the cash " + atm.getCurrentTransaction().getAmount());
        System.out.println("Collect your receipt as well...!");
        atm.setCurrentState(atm.collectReceiptState);
    }

    @Override
    public void collectReceipt() {
        System.out.println("Invalid Request");
    }
}
