package org.lld.trafficcontrolsystem;

public class TrafficLight {
    private final int id;
    private Signal currentSignal;
    private int redDuration;
    private int greenDuration;
    private int yellowDuration;

    public TrafficLight(int id, int redDuration, int greenDuration, int yellowDuration) {
        this.id = id;
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        currentSignal = Signal.RED;
    }

    public synchronized void changeSignal(Signal newSignal) {
        currentSignal = newSignal;
        notifyObservers();
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }

    private void notifyObservers() {
    }
}
