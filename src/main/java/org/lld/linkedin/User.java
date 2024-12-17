package org.lld.linkedin;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private String name;
    private String email;
    private String password;
    private final Profile profile;
    private final List<Connection> connections = new ArrayList<>();

    public User(String name, String email, String password, Profile profile) {
        id = Utils.getId();
        this.name = name;
        this.email = email;
        this.profile = profile;
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

    public Profile getProfile() {
        return profile;
    }
}
