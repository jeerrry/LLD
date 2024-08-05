package org.lld.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final int id;
    private final List<Parking> parkingSpots = new ArrayList<>();

    public ParkingFloor(int id) {
        this.id = id;
    }

    public void addParking(Parking parking) {
        parkingSpots.add(parking);
    }

    public void removeParking(int id) {
        parkingSpots.removeIf(p -> p.getId() == id);
    }

    public void updateParking(Parking parking) {
        parkingSpots.stream().findFirst().filter(x -> x.getId() == parking.getId()).ifPresent(x -> {
            x.type = parking.type;
            x.available = parking.available;
        });
    }

    public synchronized List<Parking> getAvailableParking(VehicleType type) {
        return parkingSpots.stream().filter(Parking::isAvailable).toList();
    }

    public synchronized boolean bookParking(int id, String carId) {
        Parking parking = parkingSpots.stream().filter(x -> x.getId() == id).findFirst().orElse(null);;
        if(parking == null) return false;

        parking.park(carId);
        return true;
    }

    public int getId() {
        return id;
    }
}
