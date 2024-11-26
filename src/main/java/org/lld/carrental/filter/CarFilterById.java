package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterById implements Filter {
    private final int id;

    public CarFilterById(int id) {
        this.id = id;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getId() == id).toList();
    }
}
