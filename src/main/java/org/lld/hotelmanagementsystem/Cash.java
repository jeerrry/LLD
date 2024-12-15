package org.lld.hotelmanagementsystem;

public class Cash implements Payment {
    @Override
    public void pay(Reservation reservation) {
        reservation.setPaymentType(PaymentType.CASH);
        reservation.updatePaidStatus(true);
        System.out.println("Payment of " + reservation.dueAmount() + " made to hotel via cash");
    }
}
