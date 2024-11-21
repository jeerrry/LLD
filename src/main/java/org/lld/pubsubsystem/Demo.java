package org.lld.pubsubsystem;

public class Demo {
    public static void main(String[] args) {
        var pubsubSystem = new PubSubSystem();
        var topic1 = new Topic("topic1");
        var topic2 = new Topic("topic2");
        var subscriber1 = new TextSubscriber("subscriber1");
        var subscriber2 = new TextSubscriber("subscriber2");
        var subscriber3 = new TextSubscriber("subscriber3");
        var subscriber4 = new TextSubscriber("subscriber4");
        var subscriber5 = new TextSubscriber("subscriber5");

        pubsubSystem.addTopic(topic1.getName(), topic1);
        pubsubSystem.addTopic(topic2.getName(), topic2);

        topic1.registerObserver(subscriber1);
        topic1.registerObserver(subscriber2);
        topic2.registerObserver(subscriber3);
        topic2.registerObserver(subscriber4);
        topic2.registerObserver(subscriber5);

        pubsubSystem.getTopic(topic1.getName()).notifyObservers("This is a broadcast via topic 1");
        pubsubSystem.getTopic(topic2.getName()).notifyObservers("This is a broadcast via topic 2");
    }
}
