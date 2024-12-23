package org.lld.linkedin.filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericFilter<T> implements Filter<T> {
    private final Predicate<T> predicate;

    public GenericFilter(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public List<T> apply(List<T> items) {
        return items.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
