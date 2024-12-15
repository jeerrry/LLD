package org.lld.hotelmanagementsystem;

public class Guest {
    private final int id;
    private final String name;
    private final String phone;
    private final String email;

    public Guest(String name, String phone, String email) {
        this.id = Utils.getId();
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
