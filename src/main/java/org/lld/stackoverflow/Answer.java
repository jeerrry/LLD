package org.lld.stackoverflow;

import java.util.HashSet;

public class Answer extends Activity{
    public Answer(int id, String content, User user) {
        super(id, "", content, user, new HashSet<>());
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", content=" + content + ", user=" + user + "]";
    }
}
