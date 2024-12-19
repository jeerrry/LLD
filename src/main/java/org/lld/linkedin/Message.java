package org.lld.linkedin;

import java.time.LocalDate;

public class Message {
    private final int id;
    private final LocalDate date;
    private final User sender;
    private final User receiver;
    private String text;
    private boolean read = false;

    public Message(User sender, User receiver, String text) {
        this.id = Utils.getId();
        this.date = LocalDate.now();
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }

    public void updateText(String text) {
        this.text = text;
    }

    public void setRead() {
        read = true;
    }

    public boolean isRead() {
        return read;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }
}
