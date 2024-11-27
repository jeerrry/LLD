package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterCarById implements FilterCar {
    private final int id;

    public CarFilterCarById(int id) {
        this.id = id;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getId() == id).toList();
    }
}
