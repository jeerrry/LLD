package org.lld.stackoverflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Activity {
    protected int id;
    protected String title;
    protected String content;
    protected User user;
    protected Set<User> upVote = new HashSet<>();
    protected Set<User> downVote = new HashSet<>();

    protected Set<String> tags = new HashSet<>();
    protected List<Comment> comments = new ArrayList<>();
    protected List<Answer> answers = new ArrayList<>();

    public Activity(int id, String title, String content, User user, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.tags.addAll(tags);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comment getCommentById(int id) {
        return comments.stream().filter(comment -> comment.getId() == id).findFirst().orElse(null);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void displayAnswers() {
        for (Answer answer : answers) {
            System.out.println(answer);
        }
    }

    public void upVote(User user) {
        if(upVote.contains(user)) return;

        upVote.add(user);
        user.increaseReputation(1);
    }

    public void downVote(User user) {
        if(upVote.contains(user)) return;

        downVote.add(user);
        user.increaseReputation(-1);
    }

    public int getVote() {
        return upVote.size() - downVote.size();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public boolean hasTag(String... tags) {
        for (String tag : tags) {
            if (this.tags.contains(tag)) return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Activity [title=" + title + ", content=" + content + ", user=" + user +"]";
    }
}
