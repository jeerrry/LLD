package org.lld.carrental.payment;

public class Paypal implements Payment {
    @Override
    public boolean charge(double amount) {
        return true;
    }
}
