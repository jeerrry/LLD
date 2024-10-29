package org.lld.taskmanagementsystem;

public class PrioritySpecification implements Specification<Task> {
    private final Priority priority;

    public PrioritySpecification(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean isSatisfiedBy(Task task) {
        return task.getPriority() == priority;
    }
}
