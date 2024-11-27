package org.lld.carrental.filter;

import org.lld.carrental.Car;
import org.lld.carrental.Reservation;

import java.time.LocalDate;
import java.util.List;

public class ReservationFilterByStartAndEndDate implements FilterReservation {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final List<Car> cars;

    public ReservationFilterByStartAndEndDate(LocalDate startDate, LocalDate endDate, List<Car> cars) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.cars = cars;
    }

    @Override
    public List<Reservation> filter(List<Reservation> reservations) {
        return reservations.stream().filter(x ->
                cars.contains(x.getCar()) && isDateOverlapping(x.getStartDate(), x.getEndDate())).toList();
    }

    private boolean isDateOverlapping(LocalDate start, LocalDate end) {
        var smaller = new LocalDate[]{start, end};
        var bigger = new LocalDate[]{startDate, endDate};
        if (startDate.isBefore(start)) {
            bigger = smaller;
            smaller = new LocalDate[]{startDate, endDate};
        }

        return smaller[1].isAfter(bigger[0]);
    }
}
