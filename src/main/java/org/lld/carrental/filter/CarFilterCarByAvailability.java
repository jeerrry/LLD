package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterCarByAvailability implements FilterCar {
    private final boolean isAvailable;

    public CarFilterCarByAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.isAvailable() == isAvailable).toList();
    }
}
