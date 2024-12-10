package org.lld.atm;

public class CreditTransaction extends Transaction {

    public CreditTransaction(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() {
        this.account.credit(this.amount);
    }
}
