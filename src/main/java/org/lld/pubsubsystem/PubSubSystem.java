package org.lld.pubsubsystem;

import java.util.concurrent.ConcurrentHashMap;

public class PubSubSystem {
    private final ConcurrentHashMap<String, Subject> topics;

    public PubSubSystem() {
        topics = new ConcurrentHashMap<>();
    }

    public void addTopic(String topic, Subject subject) {
        topics.put(topic, subject);
    }

    public Subject getTopic(String topic) {
        if(!topics.containsKey(topic)) return null;

        return topics.get(topic);
    }

    private void removeTopic(String topic) {
        if (!topics.containsKey(topic)) return;

        topics.remove(topic);
    }
}
