package org.lld.linkedin;

public class Notification {
    private final int id;
    private final String text;
    private final Account sender;
    private final Account receiver;
    private final NotificationType type;
    private boolean read = false;

    public Notification(String text, Account sender, Account receiver, NotificationType type) {
        id = Utils.getId();
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setNotificationStatus(boolean read) {
        this.read = read;
    }

    public boolean isRead() {
        return read;
    }

    public NotificationType getType() {
        return type;
    }
}
