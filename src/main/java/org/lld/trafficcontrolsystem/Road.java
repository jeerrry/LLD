package org.lld.trafficcontrolsystem;

public class Road {
    private final int id;
    private final String roadName;
    private TrafficLight trafficLight;

    public Road(int id, String roadName, TrafficLight trafficLight) {
        this.id = id;
        this.roadName = roadName;
        this.trafficLight = trafficLight;
    }

    public void updateTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public int getId() {
        return id;
    }

    public String getRoadName() {
        return roadName;
    }
}
