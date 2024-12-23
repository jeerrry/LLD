package org.lld.linkedin;

import org.lld.linkedin.behavior.Deleteable;
import org.lld.linkedin.behavior.Emailable;
import org.lld.linkedin.behavior.Identifiable;
import org.lld.linkedin.behavior.Named;

public abstract class Account implements Identifiable, Named, Emailable, Deleteable {
    private final int id;
    private String name;
    private String email;
    private String password;
    private boolean deleted = false;

    public Account(String name, String email, String password) {
        id = Utils.getId();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeleted(boolean ban) {
        this.deleted = ban;
    }

    public boolean getDelete() {
        return deleted;
    }
}
