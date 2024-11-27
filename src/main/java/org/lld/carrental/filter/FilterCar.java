package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public interface FilterCar {
    public List<Car> filter(List<Car> list);
}
