package org.lld.taskmanagementsystem;

public class UserSpecification implements Specification<Task> {
    private final User user;

    public UserSpecification(User user) {
        this.user = user;
    }

    @Override
    public boolean isSatisfiedBy(Task task) {
        return task.getAssignedUser() != null && task.getAssignedUser().getId() == user.getId();
    }
}
