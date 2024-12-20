package org.lld.linkedin;

import java.time.LocalDate;

public abstract class Post {
    private final int id;
    private final User user;
    private final LocalDate date;
    private String text;

    public Post(User user, LocalDate date, String text) {
        this.id = Utils.getId();
        this.user = user;
        this.date = date;
        this.text = text;
    }

    public void updatePost(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
