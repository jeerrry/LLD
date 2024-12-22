package org.lld.linkedin;

import java.time.LocalDate;

public class StatusPost extends Post {
    public StatusPost(Account account, LocalDate date, String text) {
        super(account, date, text);
    }
}
