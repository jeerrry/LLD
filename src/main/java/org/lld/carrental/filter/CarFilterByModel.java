package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterByModel implements Filter {
    private final String model;

    public CarFilterByModel(String model) {
        this.model = model;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getModel().equalsIgnoreCase(model)).toList();
    }
}
