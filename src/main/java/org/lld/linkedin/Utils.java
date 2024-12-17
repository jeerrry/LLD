package org.lld.linkedin;

import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    private static final AtomicInteger id = new AtomicInteger(0);

    public static int getId() {
        return id.incrementAndGet();
    }
}
