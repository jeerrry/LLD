package org.lld.atm;

public class ATMDemo {
    public static void main(String[] args) {
        var bankingService = new BankingService();
        var atm = new ATM(bankingService, new CashDispenser(10000));
        var debitCard = new Card("2123-4421-2212-4212", "123", CardType.DEBIT, CardProvider.VISA);
        var account = new Account("Uzair Tariq");
        account.addCard(debitCard);
        account.credit(5000);

        bankingService.addAccount(account);

        atm.insertCard(debitCard);
        atm.inputWithDrawlAmount(6000);
        atm.inputWithDrawlAmount(2000);
        atm.collectCash();
        atm.collectReceipt();

        System.out.println(account.getBalance());
    }
}
