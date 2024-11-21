package org.lld.pubsubsystem;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {
    private final String name;
    private final List<Observer> observers;

    public Topic(String name) {
        this.name = name;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        if (observers.contains(o)) {
            return;
        }

        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!observers.contains(o)) {
            return;
        }

        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer o : observers) {
            o.update(arg);
        }
    }

    public String getName() {
        return name;
    }
}
