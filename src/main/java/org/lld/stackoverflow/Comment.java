package org.lld.stackoverflow;

import java.util.HashSet;

public class Comment extends Activity{
    public Comment(int id, String content, User user) {
        super(id, "", content, user, new HashSet<>());
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", content=" + content + ", user=" + user + "]";
    }
}
