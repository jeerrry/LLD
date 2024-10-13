package org.lld.stackoverflow;

public class User {
    private final int id;
    private final String name;
    private final String email;
    private int reputation;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        reputation = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public void increaseReputation(int factor) {
        if (reputation < 0) return;

        reputation += factor;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}
