package org.lld.linkedin;

import org.lld.linkedin.filter.FilterPredicates;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private static AccountService instance;

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    private AccountService() {
    }

    private List<Account> accounts = new ArrayList<Account>();

    public boolean addAccount(Account account) {
        boolean userDoesNotExist = SearchService.getInstance().search(accounts, FilterPredicates.emailFilter(account.getEmail())).isEmpty();
        if (userDoesNotExist) {
            accounts.add(account);
            System.out.println("User registered: " + account.getEmail());
            return true;
        }

        System.out.println("User already registered: " + account.getEmail());
        return false;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean removeAccount(Account account) {
        account = SearchService.getInstance().search(accounts, FilterPredicates.emailFilter(account.getEmail())).stream().findFirst().orElse(null);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        account.setDeleted(true);
        return true;
    }

    public boolean login(String email, String password) {
        Account account = SearchService.getInstance().search(accounts, FilterPredicates.emailFilter(email)).stream().findFirst().orElse(null);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        if (password.equals(account.getPassword())) {
            System.out.println("Login successful for user: " + account.getEmail());
            return true;
        }

        System.out.println("Login failed for user: " + account.getEmail());
        return false;
    }
}
