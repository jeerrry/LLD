package org.lld.taskmanagementsystem;

import java.util.Date;

public class DateSpecification implements Specification<Task> {
    private final Date dueDate;

    public DateSpecification(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean isSatisfiedBy(Task task) {
        return dueDate.equals(task.getDueDate());
    }
}
