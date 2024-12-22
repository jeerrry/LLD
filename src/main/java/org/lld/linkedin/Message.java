package org.lld.linkedin;

import java.time.LocalDate;

public class Message {
    private final int id;
    private final LocalDate date;
    private final Account sender;
    private final Account receiver;
    private String text;
    private boolean read = false;

    public Message(Account sender, Account receiver, String text) {
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

    public Account getReceiver() {
        return receiver;
    }

    public Account getSender() {
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
