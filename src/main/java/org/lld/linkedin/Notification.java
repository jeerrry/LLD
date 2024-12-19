package org.lld.linkedin;

public class Notification {
    private final int id;
    private final String text;
    private final User sender;
    private final User receiver;
    private boolean read = false;

    public Notification(String text, User sender, User receiver) {
        id = Utils.getId();
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setNotificationStatus(boolean read) {
        this.read = read;
    }

    public boolean isRead() {
        return read;
    }
}
