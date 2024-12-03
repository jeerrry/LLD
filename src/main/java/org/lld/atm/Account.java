package org.lld.atm;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final int id;
    private final String username;
    private final List<Card> cards = new ArrayList<>();
    private double balance = 0;

    public Account(String username) {
        this.username = username;
        this.id = Utils.getID();
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
