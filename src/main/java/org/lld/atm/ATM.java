package org.lld.atm;

public class ATM {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    public ATMReadyState readyState;
    public ATMCashInputState cashInputState;
    public ATMCashCollectState cashCollectState;
    public ATMCollectReceiptState collectReceiptState;
    private MachineState currentState = null;
    private Account currentAccount = null;
    private Transaction currentTransaction = null;

    public ATM(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
        readyState = new ATMReadyState(this);
        cashInputState = new ATMCashInputState(this);
        cashCollectState = new ATMCashCollectState(this);
        collectReceiptState = new ATMCollectReceiptState(this);
    }

    public BankingService getBankingService() {
        return bankingService;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void setCurrentState(MachineState state) {
        currentState = state;
    }

    public MachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentAccount(Account account) {
        currentAccount = account;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
}
