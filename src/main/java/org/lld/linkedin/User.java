package org.lld.linkedin;

public class User extends Account {
    private final Profile profile;

    public User(String name, String email, String password, Profile profile) {
        super(name, email, password);
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }
}
