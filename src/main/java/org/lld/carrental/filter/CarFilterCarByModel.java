package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterCarByModel implements FilterCar {
    private final String model;

    public CarFilterCarByModel(String model) {
        this.model = model;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getModel().equalsIgnoreCase(model)).toList();
    }
}
