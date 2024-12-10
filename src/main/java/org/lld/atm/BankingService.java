package org.lld.atm;

import java.util.ArrayList;
import java.util.List;

public class BankingService {
    private final List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountById(int id) {
        return accounts.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public Account getAccountByCard(Card card) {
        return accounts.stream().filter(x -> x.getCards().contains(card)).findFirst().orElse(null);
    }

    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }
}
