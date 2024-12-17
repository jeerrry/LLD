package org.lld.linkedin;

import java.time.LocalDate;

public class Connection {
    private final int id;
    private final LocalDate date;
    private final User user1;
    private final User user2;
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

    public void acceptConnectionRequest() {
        connected = true;
    }

    public boolean isConnected() {
        return connected;
    }
}
