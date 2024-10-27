package org.lld.trafficcontrolsystem;

import java.util.HashMap;

public class TrafficController {
    private static TrafficController instance = null;
    private final HashMap<Integer, Road> roads;

    public static TrafficController getInstance() {
        if (instance == null) {
            instance = new TrafficController();
        }

        return instance;
    }

    private TrafficController() {
        roads = new HashMap<>();
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
    }

    public void removeRoad(Road road) {
        roads.remove(road.getId());
    }

    public void startTrafficControl() {
        for (Road road : roads.values()) {
            var light = road.getTrafficLight();
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(light.getRedDuration());
                        light.changeSignal(Signal.YELLOW);
                        Thread.sleep(light.getYellowDuration());
                        light.changeSignal(Signal.GREEN);
                        Thread.sleep(light.getGreenDuration());
                        light.changeSignal(Signal.RED);
                        Thread.sleep(light.getRedDuration());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void handleEmergency(int roadId) {
        var road = roads.get(roadId);
        if(road != null) {
            var light = road.getTrafficLight();
            light.changeSignal(Signal.GREEN);
        }
    }
}
