package org.lld.taskmanagementsystem;

import java.util.Date;

public class Task {
    private final int id;
    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private Status status;
    private User assignedUser;
    private boolean enableReminder = false;

    public Task(String title, String description, Date dueDate, Priority priority, Status status, User assignedUser) {
        this.id = IDGenerator.getID();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.assignedUser = assignedUser;
    }

    public int getId() {
        return id;
    }

    public synchronized String getTitle() {
        return title;
    }

    public synchronized void setTitle(String title) {
        this.title = title;
    }

    public synchronized Date getDueDate() {
        return dueDate;
    }

    public synchronized void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public synchronized Priority getPriority() {
        return priority;
    }

    public synchronized void setPriority(Priority priority) {
        this.priority = priority;
    }

    public synchronized Status getStatus() {
        return status;
    }

    public synchronized void setStatus(Status status) {
        this.status = status;
    }

    public synchronized String getDescription() {
        return description;
    }

    public synchronized void setDescription(String description) {
        this.description = description;
    }

    public synchronized User getAssignedUser() {
        return assignedUser;
    }

    public synchronized void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public synchronized boolean isEnableReminder() {
        return enableReminder;
    }

    public synchronized void setEnableReminder(boolean enableReminder) {
        this.enableReminder = enableReminder;
    }

    @Override
    public String toString() {
        return "Task{" +
                "assignedUser=" + assignedUser +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
