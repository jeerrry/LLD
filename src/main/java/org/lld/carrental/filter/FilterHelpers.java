package org.lld.carrental.filter;

public class FilterHelpers {
    public static boolean compare(float price, String operator, float threshold) {
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
