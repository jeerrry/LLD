package org.lld.stackoverflow;

import java.util.Set;

public class Question extends Activity{
    public Question(int id, String title, String content, User user, Set<String> tags) {
        super(id, title, content, user, tags);
    }

    public Answer getAnswerById(int id) {
        return answers.stream().filter(answer -> answer.getId() == id).findFirst().orElse(null);
    }
}
