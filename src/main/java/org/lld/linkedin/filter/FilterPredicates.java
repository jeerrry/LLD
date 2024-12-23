package org.lld.linkedin.filter;

import org.lld.linkedin.behavior.Deleteable;
import org.lld.linkedin.behavior.Emailable;
import org.lld.linkedin.behavior.Identifiable;

public class FilterPredicates {
    public static <T extends Identifiable> GenericFilter<T> idFilter(int id) {
        return new GenericFilter<>(item -> item.getId() == id);
    }

    public static <T extends Emailable> GenericFilter<T> emailFilter(String email) {
        return new GenericFilter<>(item -> item.getEmail().equalsIgnoreCase(email));
    }

    public static <T extends Deleteable> GenericFilter<T> deleteFilter(boolean deleted) {
        return new GenericFilter<>(item -> item.getDelete() == deleted);
    }
}
