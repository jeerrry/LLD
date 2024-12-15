package org.lld.hotelmanagementsystem;

public class Card implements Payment {
    @Override
    public void pay(Reservation reservation) {
        reservation.setPaymentType(PaymentType.CARD);
        reservation.updatePaidStatus(true);
        System.out.println("Payment of " + reservation.dueAmount() + " made using Card");
    }
}
