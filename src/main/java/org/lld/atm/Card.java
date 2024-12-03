package org.lld.atm;

public class Card {
    private final int id;
    private final String number;
    private final int ccv;
    private final CardType type;
    private final CardProvider provider;
    private String pin;

    public Card(String number, int ccv, CardType type, CardProvider provider) {
        this.type = type;
        this.provider = provider;
        this.id = Utils.getID();
        this.number = number;
        this.ccv = ccv;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public int getCcv() {
        return ccv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public CardType getType() {
        return type;
    }

    public CardProvider getProvider() {
        return provider;
    }
}
