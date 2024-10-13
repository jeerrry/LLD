package org.lld.stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stackoverflow {
    public List<Activity> activities = new ArrayList<>();
    public List<User> users = new ArrayList<>();
    private static Stackoverflow instance = null;

    public static Stackoverflow getInstance() {
        if(instance == null) {
            instance = new Stackoverflow();
        }
        return instance;
    }

    public void addQuestion(Question question) {
        activities.add(question);
    }

    public Optional<Activity> findQuestionById(int id) {
        return activities.stream().findFirst().filter(x -> x.id == id);
    }

    public Optional<Activity> findQuestionByTitle(String title) {
        return activities.stream().filter(x -> x.title.equals(title)).findFirst();
    }

    public List<Activity> findQuestionByTags(String... tags) {
        return activities.stream().filter(x -> x.hasTag(tags)).toList();
    }

    public void listQuestions() {
        for(Activity a : activities) {
            System.out.println(a);
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
}
