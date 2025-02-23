package org.lld.linkedin;

import org.lld.linkedin.behavior.*;

import java.time.LocalDate;

public abstract class Post implements Named, Identifiable, Dateable, Accountable, Descriptionable {
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

    public String getName() {
        return text;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return text;
    }
}
