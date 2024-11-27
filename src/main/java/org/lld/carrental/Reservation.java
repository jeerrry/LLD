package org.lld.carrental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private final int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Customer customer;
    private Car car;
    private boolean paid = false;

    public Reservation(LocalDate startDate, LocalDate endDate, Customer customer, Car car) {
        this.id = Helper.getId();
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public float getTotalRent() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);

        return Math.max(1, days) * car.getDailyRent();
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
