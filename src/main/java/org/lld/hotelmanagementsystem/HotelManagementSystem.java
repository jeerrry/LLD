package org.lld.hotelmanagementsystem;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;

    public static HotelManagementSystem getInstance() {
        if (instance == null) {
            instance = new HotelManagementSystem();
        }
        return instance;
    }

    private HotelManagementSystem() {
    }

    private List<Room> rooms = new CopyOnWriteArrayList<>();
    private List<Guest> guests = new CopyOnWriteArrayList<>();
    private List<Reservation> reservations = new CopyOnWriteArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public Reservation makeReservation(Guest guest, LocalDate startDate, LocalDate endDate, RoomType roomType) {
        var filteredRooms = new java.util.ArrayList<>(rooms.stream().filter(x -> x.isAvailable() && x.getRoomType() == roomType).toList());
        var targetReservations = reservations.stream().filter(x -> x.getRoom().getRoomType() == roomType
                && filteredRooms.contains(x.getRoom())).toList();
        for (Reservation reservation : targetReservations) {
            if (Utils.datesOverlap(reservation.getStartDate(), reservation.getEndDate(), startDate, endDate)) {
                filteredRooms.remove(reservation.getRoom());
            }
        }

        if (filteredRooms.isEmpty()) {
            System.out.println("No rooms available for room type " + roomType);
            return null;
        }

        var reservation = new Reservation(guest, filteredRooms.getFirst(), startDate, endDate, false);
        reservations.add(reservation);
        return reservation;
    }

    public void cancelReservation(int id) {
        Reservation reservation = reservations.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (reservation == null) {
            return;
        }

        reservations.remove(reservation);
    }

    public void checkIn(int reservationId) {
        Reservation reservation = reservations.stream().filter(x -> x.getId() == reservationId).findFirst().orElse(null);
        if (reservation == null) {
            System.out.println("No reservation found for " + reservationId);
            return;
        }

        reservation.setCheckInDate(LocalDate.now());
    }

    public void checkOut(int reservationId, Payment payment) {
        Reservation reservation = reservations.stream().filter(x -> x.getId() == reservationId).findFirst().orElse(null);
        if (reservation == null) {
            System.out.println("No reservation found for " + reservationId);
            return;
        }

        reservation.setCheckOutDate(LocalDate.now());
        payment.pay(reservation);
    }
}
