package org.lld.taskmanagementsystem;

import java.util.Date;

public class NotificationSpecification implements Specification<Task> {
    @Override
    public boolean isSatisfiedBy(Task task) {
        return task.getDueDate().after(new Date()) && task.isEnableReminder();
    }
}
