package org.lld.hotelmanagementsystem;

public class Room {
    private final int id;
    private final RoomType roomType;
    private final double price;
    private boolean available;

    public Room(RoomType roomType, double price, boolean available) {
        id = Utils.getId();
        this.roomType = roomType;
        this.price = price;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getId() {
        return id;
    }
}
