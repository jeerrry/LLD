package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterCarByDailyRent implements FilterCar {
    private final float threshold;
    private final String operator;

    public CarFilterCarByDailyRent(float threshold, String operator) {
        this.threshold = threshold;
        this.operator = operator;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> compare(x.getDailyRent())).toList();
    }

    private boolean compare(float price) {
        return FilterHelpers.compare(price, operator, threshold);
    }
}
