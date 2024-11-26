package org.lld.carrental;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private final int id;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private Car car;
    private boolean paid = false;

    public Reservation(Date startDate, Date endDate, Customer customer, Car car) {
        this.id = Helper.getId();
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getTotalRent() {
        long diff = endDate.getTime() - startDate.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(diff);

        return Math.max(1, days) * car.getDailyRent();
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
