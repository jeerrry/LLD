package org.lld.carrental;

public class Customer {
    private final int id;
    private String name;
    private String contact;
    private String license;

    public Customer(String name, String contact, String license) {
        this.id = Helper.getId();
        this.name = name;
        this.contact = contact;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
