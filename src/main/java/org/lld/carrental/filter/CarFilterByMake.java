package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterByMake implements Filter {
    private final String make;

    public CarFilterByMake(String make) {
        this.make = make;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> x.getMake().equalsIgnoreCase(make)).toList();
    }
}
