package org.lld.atm;

public interface MachineState {
    void readyState(Card card);
    void targetAmount(double amount);
    void collectCash();
    void collectReceipt();
}
