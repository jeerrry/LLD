package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public interface Filter {
    public List<Car> filter(List<Car> list);
}
