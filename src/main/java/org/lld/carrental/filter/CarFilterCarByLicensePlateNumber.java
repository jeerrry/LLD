package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterCarByLicensePlateNumber implements FilterCar {
    public String licensePlateNumber;

    public CarFilterCarByLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getLicensePlateNumber().equalsIgnoreCase(licensePlateNumber)).toList();
    }
}
