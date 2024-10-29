package org.lld.taskmanagementsystem;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}
