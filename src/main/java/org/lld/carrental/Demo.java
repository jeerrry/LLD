package org.lld.carrental;

import org.lld.carrental.filter.CarFilterCarByMake;
import org.lld.carrental.filter.CarFilterCarByModel;
import org.lld.carrental.filter.ReservationFilterByStartAndEndDate;
import org.lld.carrental.payment.CreditCard;

import java.time.LocalDate;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();

        // Add cars to the rental system
        rentalSystem.addCar(new Car("Toyota", "Camry", "ABC123", 2022, 50.0f));
        rentalSystem.addCar(new Car("Honda", "Civic", "XYZ789", 2022, 45.0f));
        rentalSystem.addCar(new Car("Ford", "Mustang", "DEF456", 2023, 80.0f));

        // Create customers
        Customer customer1 = new Customer("John Doe", "john@example.com", "DL1234");

        // Make reservations
        var startDate = LocalDate.now();
        var endDate = startDate.plusDays(3);
        var availableCars = rentalSystem.filterCar(
                new CarFilterCarByMake("Toyota"),
                new CarFilterCarByModel("Camry"));
        List<Reservation> reservations = rentalSystem.filterReservations(new ReservationFilterByStartAndEndDate(startDate, endDate, availableCars));
        for (Reservation reservation : reservations) {
            availableCars.remove(reservation.getCar());
        }

        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.getFirst();
            var reservation = new Reservation(startDate, endDate, customer1, selectedCar);
            rentalSystem.addReservation(reservation);
            rentalSystem.chargeCustomer(reservation, new CreditCard());
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
    }
}
