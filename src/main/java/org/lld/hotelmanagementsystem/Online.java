package org.lld.hotelmanagementsystem;

public class Online implements Payment {
    @Override
    public void pay(Reservation reservation) {
        reservation.setPaymentType(PaymentType.ONLINE);
        reservation.updatePaidStatus(true);
        System.out.println("Payment of " + reservation.dueAmount() + " made via online payment");
    }
}
