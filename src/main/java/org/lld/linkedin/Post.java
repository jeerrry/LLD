package org.lld.linkedin;

import java.time.LocalDate;

public abstract class Post {
    private final int id;
    private final Account account;
    private final LocalDate date;
    private String text;

    public Post(Account account, LocalDate date, String text) {
        this.id = Utils.getId();
        this.account = account;
        this.date = date;
        this.text = text;
    }

    public void updatePost(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public Account getUser() {
        return account;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
