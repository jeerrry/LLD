package org.lld.carrental.payment;

public class CreditCard implements Payment {
    @Override
    public boolean charge(double amount) {
        return true;
    }
}
