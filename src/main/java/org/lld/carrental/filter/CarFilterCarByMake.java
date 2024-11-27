package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterCarByMake implements FilterCar {
    private final String make;

    public CarFilterCarByMake(String make) {
        this.make = make;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getMake().equalsIgnoreCase(make)).toList();
    }
}
