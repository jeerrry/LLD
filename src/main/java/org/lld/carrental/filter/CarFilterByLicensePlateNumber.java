package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterByLicensePlateNumber implements Filter {
    public String licensePlateNumber;

    public CarFilterByLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getLicensePlateNumber().equalsIgnoreCase(licensePlateNumber)).toList();
    }
}
