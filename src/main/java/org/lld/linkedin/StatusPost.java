package org.lld.linkedin;

import java.time.LocalDate;

public class StatusPost extends Post {
    public StatusPost(User user, LocalDate date, String text) {
        super(user, date, text);
    }
}
