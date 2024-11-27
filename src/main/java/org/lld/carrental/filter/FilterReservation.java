package org.lld.carrental.filter;

import org.lld.carrental.Reservation;

import java.util.List;

public interface FilterReservation {
    List<Reservation> filter(List<Reservation> reservations);
}
