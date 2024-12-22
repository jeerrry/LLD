package org.lld.linkedin;

import java.time.LocalDate;
import java.util.Objects;

public class Connection {
    private final int id;
    private final LocalDate date;
    private final Account sender; // Connection Request Sender
    private final Account receiver;// Connection Request Receiver
    private boolean connected = false;

    public Connection(Account sender, Account receiver) {
        id = Utils.getId();
        this.date = LocalDate.now();
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public Account getConnectedAccount(Account account) {
        return account.equals(sender) ? receiver : sender;
    }

    public void setConnectionStatus(boolean connected) {
        this.connected = connected;
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean isSender(Account account) {
        return account.getId() == sender.getId();
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
