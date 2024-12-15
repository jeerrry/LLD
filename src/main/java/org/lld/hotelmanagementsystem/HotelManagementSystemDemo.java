package org.lld.hotelmanagementsystem;

import java.time.LocalDate;

public class HotelManagementSystemDemo {
    public static void main(String[] args) {
        var hms = HotelManagementSystem.getInstance();

        var guest1 = new Guest("Uzair", "Tariq", "temp@gmail.com");
        var guest2 = new Guest("Ali", "Raza", "temp2@gmail.com");
        hms.addGuest(guest1);
        hms.addGuest(guest2);

        var room1 = new Room(RoomType.SINGLE, 10, true);
        var room2 = new Room(RoomType.DOUBLE, 20, true);
        hms.addRoom(room1);
        hms.addRoom(room2);

        var checkInDate = LocalDate.now();
        var checkOutDate = LocalDate.now().plusDays(4);
        var reservation = hms.makeReservation(guest1, checkInDate, checkOutDate, RoomType.SINGLE);
        if (reservation == null) {
            System.out.println("Reservation has not been made");
            return;
        }

        hms.checkIn(reservation.getId());
        System.out.println("Checked in successfully");

        hms.checkOut(reservation.getId(), new Card());
    }
}
