package org.lld.linkedin;

import java.time.LocalDate;
import java.util.Objects;

public class Connection {
    private final int id;
    private final LocalDate date;
    private final User user1; // Connection Request Sender
    private final User user2; // Connection Request Receiver
    private boolean connected = false;

    public Connection(User user1, User user2) {
        id = Utils.getId();
        this.date = LocalDate.now();
        this.user1 = user1;
        this.user2 = user2;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public User getConnectedUser(User user) {
        return user.equals(user1) ? user2 : user1;
    }

    public void setConnectionStatus(boolean connected) {
        connected = true;
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean isSender(User user) {
        return user.getId() == user1.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Connection connection = (Connection) obj;
        return user1.getId() == connection.user1.getId() && user2.getId() == connection.user2.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }
}
