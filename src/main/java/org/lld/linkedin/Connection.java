package org.lld.linkedin;

import java.time.LocalDate;
import java.util.Objects;

public class Connection {
    private final int id;
    private final LocalDate date;
    private final User sender; // Connection Request Sender
    private final User receiver;// Connection Request Receiver
    private boolean connected = false;

    public Connection(User sender, User user2) {
        id = Utils.getId();
        this.date = LocalDate.now();
        this.sender = sender;
        this.receiver = user2;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getConnectedUser(User user) {
        return user.equals(sender) ? receiver : sender;
    }

    public void setConnectionStatus(boolean connected) {
        connected = true;
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean isSender(User user) {
        return user.getId() == sender.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Connection connection = (Connection) obj;
        return sender.getId() == connection.sender.getId() && receiver.getId() == connection.receiver.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver);
    }
}
