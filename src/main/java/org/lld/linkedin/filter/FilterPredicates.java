package org.lld.linkedin.filter;

import org.lld.linkedin.behavior.*;

public class FilterPredicates {
    public static <T extends Identifiable> GenericFilter<T> idFilter(int id) {
        return new GenericFilter<>(item -> item.getId() == id);
    }

    public static <T extends Descriptionable> GenericFilter<T> descriptionFilter(String text) {
        return new GenericFilter<>(item -> item.getDescription().toLowerCase().contains(text));
    }

    public static <T extends Named> GenericFilter<T> nameFilter(String name) {
        return new GenericFilter<>(item -> item.getName().toLowerCase().contains(name));
    }

    public static <T extends Emailable> GenericFilter<T> emailFilter(String email) {
        return new GenericFilter<>(item -> item.getEmail().equalsIgnoreCase(email));
    }

    public static <T extends Deleteable> GenericFilter<T> deleteFilter(boolean deleted) {
        return new GenericFilter<>(item -> item.getDelete() == deleted);
    }
}
