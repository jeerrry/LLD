package org.lld.carrental;

import org.lld.carrental.filter.CarFilterCarByAvailability;
import org.lld.carrental.filter.CarFilterCarById;
import org.lld.carrental.filter.FilterCar;
import org.lld.carrental.filter.FilterReservation;
import org.lld.carrental.payment.Payment;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RentalSystem {
    private static RentalSystem instance;
    private CopyOnWriteArrayList<Car> cars;
    private CopyOnWriteArrayList<Customer> customers;
    private CopyOnWriteArrayList<Reservation> reservations;

    public static RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    private RentalSystem() {
        cars = new CopyOnWriteArrayList<>();
        customers = new CopyOnWriteArrayList<>();
        reservations = new CopyOnWriteArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Car> filterCar(FilterCar... filterCars) {
        List<Car> result = cars;
        for (FilterCar filterCar : filterCars) {
            result = filterCar.filter(result);
        }

        return result;
    }

    public List<Reservation> filterReservations(FilterReservation... filterCars) {
        List<Reservation> result = reservations;
        for (FilterReservation filterReservation : filterCars) {
            result = filterReservation.filter(result);
        }

        return result;
    }

    public synchronized void addReservation(Reservation reservation) {
        List<Car> cars = filterCar(new CarFilterCarById(reservation.getCar().getId()), new CarFilterCarByAvailability(true));
        if (cars.isEmpty()) {
            System.out.println("Reservation failed! Car not available");
            return;
        }

        cars.getFirst().setAvailable(false);
        reservations.add(reservation);
    }

    public synchronized void removeReservation(Reservation reservation) {
        Reservation booked = reservations.stream().filter(x -> x.getId() == reservation.getId()).toList().getFirst();
        reservations.remove(booked);
        System.out.println("Refund reservation: " + booked.getId() + " amount: " + booked.getTotalRent());
    }

    public boolean chargeCustomer(Reservation reservation, Payment paymentMethod) {
        float amount = reservation.getTotalRent();
        if (paymentMethod.charge(amount)) {
            reservation.setPaid(true);
            System.out.println("Reservation charged!:" + reservation.getId());
            return true;
        }

        System.out.println("Error charging reservation with ID!: " + reservation.getId());
        return false;
    }
}
