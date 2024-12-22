package org.lld.linkedin.filter;

import java.util.List;

public interface FilterPost<T> {
    List<T> filter(List<T> items);
}
