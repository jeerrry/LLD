package org.lld.carrental;

import java.time.Year;

public class Car {
    private final int id;
    private final String make;
    private final String model;
    private final String licensePlateNumber;
    private final Year year;
    private float dailyRent;
    private boolean isAvailable = true;

    public Car(String make, String model, String licensePlateNumber, Year year, float dailyRent) {
        this.id = Helper.getId();
        this.make = make;
        this.model = model;
        this.licensePlateNumber = licensePlateNumber;
        this.year = year;
        this.dailyRent = dailyRent;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Year getYear() {
        return year;
    }

    public void setDailyRent(float dailyRent) {
        this.dailyRent = dailyRent;
    }

    public float getDailyRent() {
        return dailyRent;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
