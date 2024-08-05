package org.lld.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors = new ArrayList<ParkingFloor>();
    private static ParkingLot instance = null;

    private ParkingLot() {
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        instance.parkingFloors.add(floor);
    }

    public void removeFloor(ParkingFloor floor) {
        instance.parkingFloors.removeIf(x -> x.getId() == floor.getId());
    }

    public ParkingFloor getFloor(int id) {
        return instance.parkingFloors.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public List<Object[]> getAvailableParking(VehicleType type) {
        List<Object[]> parking = new ArrayList<>();
        for (ParkingFloor floor : parkingFloors) {
            parking.add(new Object[]{floor.getId(), floor.getAvailableParking(type)});
        }
        return parking;
    }

    public boolean bookParking(int floorId, int parkingId, String vehicleId) {
        ParkingFloor floor = getFloor(floorId);
        if (floor == null) return false;

        floor.bookParking(parkingId, vehicleId);
        return true;
    }
}
