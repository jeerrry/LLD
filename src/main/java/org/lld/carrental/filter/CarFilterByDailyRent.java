package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.util.List;

public class CarFilterByDailyRent implements Filter {
    private final float threshold;
    private final String operator;

    public CarFilterByDailyRent(float threshold, String operator) {
        this.threshold = threshold;
        this.operator = operator;
    }

    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> compare(x.getDailyRent())).toList();
    }

    private boolean compare(float price) {
        return switch (operator) {
            case ">" -> price > threshold;
            case "<" -> price < threshold;
            case ">=" -> price >= threshold;
            case "<=" -> price <= threshold;
            case "==" -> price == threshold;
            case "!=" -> price != threshold;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
