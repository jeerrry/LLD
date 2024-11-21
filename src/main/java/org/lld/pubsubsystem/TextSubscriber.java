package org.lld.pubsubsystem;

public class TextSubscriber implements Observer {
    private final String name;

    public TextSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Object args) {
        System.out.println("Message received: " + name);
    }
}
