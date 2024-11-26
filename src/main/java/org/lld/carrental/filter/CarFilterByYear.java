package org.lld.carrental.filter;

import org.lld.carrental.Car;

import java.time.Year;
import java.util.List;

public class CarFilterByYear implements Filter {
    private final Year threshold;
    private final String operator;

    public CarFilterByYear(Year threshold, String operator) {
        this.threshold = threshold;
        this.operator = operator;
    }


    @Override
    public List<Car> filter(List<Car> list) {
        return list.stream().filter(x -> compare(x.getYear())).toList();
    }

    private boolean compare(Year yearMake) {
        return switch (operator) {
            case ">" -> yearMake.isAfter(threshold);
            case "<" -> yearMake.isBefore(threshold);
            case ">=" -> yearMake.equals(threshold) || yearMake.isAfter(threshold);
            case "<=" -> yearMake.equals(threshold) || yearMake.isBefore(threshold);
            case "==" -> yearMake.equals(threshold);
            case "!=" -> !yearMake.equals(threshold);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
