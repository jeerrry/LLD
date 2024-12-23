package org.lld.linkedin;

import org.lld.linkedin.filter.Filter;

import java.util.List;

public class SearchService {
    private static SearchService instance;

    public static SearchService getInstance() {
        if (instance == null) {
            instance = new SearchService();
        }
        return instance;
    }

    private SearchService() {
    }

    public <T> List<T> search(List<T> items, Filter<T> filter) {
        return filter.apply(items);
    }
}
