package org.lld.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private final int id;
    private final Guest guest;
    private final Room room;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private PaymentType paymentType;
    private boolean reserved = true;
    private boolean paid;
    private final double price;

    public Reservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate, boolean paid) {
        this.id = Utils.getId();
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
        this.paymentType = PaymentType.UNDEFINED;
        this.price = room.getPrice();
    }

    public void updateReservation(boolean reserved) {
        this.reserved = reserved;
    }

    public void updatePaidStatus(boolean paid) {
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public double dueAmount() {
        return ChronoUnit.DAYS.between(startDate, endDate) * price;
    }
}
