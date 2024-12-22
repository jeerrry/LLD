package org.lld.linkedin;

import org.lld.linkedin.behavior.*;

import java.util.List;

public class User extends Account implements SkillFilterable, EducationFilterable, ExperienceFilterable, Summaryable, Headlineable {
    private final Profile profile;

    public User(String name, String email, String password, Profile profile) {
        super(name, email, password);
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    @Override
    public List<String> getEducation() {
        return profile.getEducations();
    }

    @Override
    public List<String> getExperience() {
        return profile.getExperiences();
    }

    @Override
    public String getHeadline() {
        return profile.getHeadline();
    }

    @Override
    public List<String> getSkills() {
        return profile.getSkills();
    }

    @Override
    public String getSummary() {
        return profile.getSummary();
    }
}
