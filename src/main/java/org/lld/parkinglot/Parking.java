package org.lld.parkinglot;

public class Parking {
    protected int id;
    protected String vehId = null;
    protected boolean available = true;
    protected VehicleType type;

    public Parking(int id, VehicleType type) {
        this.id = id;
        this.type = type;
    }

    public void park(String carId) {
        available = false;
        this.vehId = carId;
    }

    public void vacate() {
        available = true;
        vehId = null;
    }

    public boolean isAvailable() {
        return available;
    }

    public VehicleType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Parking p)) return false;

        return p.getId() == this.getId();
    }
}
