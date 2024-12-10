package org.lld.atm;

public abstract class Transaction {
    protected final double amount;
    protected final int transactionId;
    protected final Account account;

    public Transaction(Account account, double amount) {
        this.account = account;
        this.transactionId = Utils.getID();
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public abstract void execute();
}
