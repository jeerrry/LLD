package org.lld.linkedin;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private final int id;
    private String headline;
    private String summary;
    private final List<String> experiences = new ArrayList<>();
    private final List<String> educations = new ArrayList<>();
    private final List<String> skills = new ArrayList<>();

    public Profile(String headline, String summary) {
        id = Utils.getId();
        this.headline = headline;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addExperience(int index, String experience) {
        this.experiences.add(index, experience);
    }

    public void addEducation(int index, String education) {
        this.educations.add(index, education);
    }

    public void addSkill(int index, String skill) {
        this.skills.add(index, skill);
    }

    public void removeExperienceByIndex(int index) {
        this.experiences.remove(index);
    }

    public void removeEducationByIndex(int index) {
        this.educations.remove(index);
    }

    public void removeSkillByIndex(int index) {
        this.skills.remove(index);
    }

    public List<String> getExperiences() {
        return experiences;
    }

    public List<String> getEducations() {
        return educations;
    }

    public List<String> getSkills() {
        return skills;
    }
}
