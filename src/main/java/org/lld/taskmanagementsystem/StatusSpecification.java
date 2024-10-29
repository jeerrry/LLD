package org.lld.taskmanagementsystem;

public class StatusSpecification implements Specification<Task> {
    public final Status status;

    public StatusSpecification(Status status) {
        this.status = status;
    }


    @Override
    public boolean isSatisfiedBy(Task task) {
        return task.getStatus().equals(status);
    }
}
