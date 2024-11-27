package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterCarByYear implements FilterCar {
    private final int threshold;
    private final String operator;

    public CarFilterCarByYear(int threshold, String operator) {
        this.threshold = threshold;
        this.operator = operator;
    }


    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> compare(x.getYear())).toList();
    }

    private boolean compare(int yearMake) {
        return FilterHelpers.compare(yearMake, operator, threshold);
    }
}
