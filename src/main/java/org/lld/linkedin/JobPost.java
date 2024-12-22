package org.lld.linkedin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobPost extends Post {
    private final List<String> skills = new ArrayList<>();
    private String location;
    private double minSalary;
    private double maxSalary;

    public JobPost(List<String> skills, String location, double minSalary, double maxSalary, Account account, LocalDate date, String text) {
        super(account, date, text);
        this.skills.addAll(skills);
        this.location = location;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public void removeSkill(String skill) {
        skills.stream().filter(x -> x.equals(skill)).findFirst().ifPresent(skills::remove);
    }

    public void addSkill(String skill) {
        boolean contains = skills.stream().anyMatch(x -> x.equalsIgnoreCase(skill));
        if (contains) return;

        skills.add(skill);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }
}
