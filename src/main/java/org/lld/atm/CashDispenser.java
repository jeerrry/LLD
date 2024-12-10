package org.lld.atm;

public class CashDispenser {
    private double amount;

    public CashDispenser(double amount) {
        this.amount = amount;
    }

    public synchronized void dispenseCash(double amount) {
        if (amount > this.amount) {
            throw new IllegalArgumentException("amount is greater than current amount");
        }

        this.amount -= amount;
        System.out.println("Dispensing " + amount + " cash");
    }
}
