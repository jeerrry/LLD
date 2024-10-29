package org.lld.taskmanagementsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
    private static TaskManager instance = null;
    private List<Task> tasks;

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    // TODO: Annotate for must call.
    public void init() {
        startTaskReminder();
    }

    private TaskManager() {
        tasks = new ArrayList<>();
    }

    public synchronized void addTask(Task task) {
        tasks.add(task);
    }

    public synchronized void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void enableTaskReminder(Task task) {
        task.setEnableReminder(true);
    }

    public void disableTaskReminder(Task task) {
        task.setEnableReminder(false);
    }

    public void assignTask(Task task, User user) {
        task.setAssignedUser(user);
    }

    public List<Task> getUserTasks(User user) {
        var filter = new UserSpecification(user);
        var filters = new ArrayList<Specification<Task>>();
        filters.add(filter);

        return filterTask(filters);
    }

    public List<Task> getTasksByPriority(Priority priority) {
        var filter = new PrioritySpecification(priority);
        var filters = new ArrayList<Specification<Task>>();
        filters.add(filter);

        return filterTask(filters);
    }

    public List<Task> getTaskByDate(Date date) {
        var filter = new DateSpecification(date);
        var filters = new ArrayList<Specification<Task>>();
        filters.add(filter);

        return filterTask(filters);
    }

    public List<Task> getUserTasksByStatus(User user, Status status) {
        var result = getUserTasks(user);

        var filter = new StatusSpecification(Status.DONE);
        var filters = new ArrayList<Specification<Task>>();
        filters.add(filter);

        return filterTask(filters);
    }

    private List<Task> filterTask(List<Specification<Task>> filters) {
        var result = tasks;
        for (Specification<Task> filter : filters) {
            result = result.stream().filter(filter::isSatisfiedBy).toList();
        }

        return result;
    }

    public void startTaskReminder() {
        var filter = new NotificationSpecification();

        new Thread(() -> {
            var reminder = tasks.stream().filter(filter::isSatisfiedBy).toList();
            for (var reminderTask : reminder) {
                System.out.println("Reminder Task: " + reminderTask);
                reminderTask.setEnableReminder(false);
            }
        }).start();
    }
}
