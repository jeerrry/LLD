package org.lld.atm;

public class DebitTransaction extends Transaction {

    public DebitTransaction(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() {
        this.account.debit(amount);
    }
}
