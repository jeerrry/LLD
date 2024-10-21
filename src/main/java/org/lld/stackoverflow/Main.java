package org.lld.stackoverflow;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var user1 = new User(1, "Uzair", "uzi@gmail.com");
        var user2 = new User(2, "Ali", "ali@gmail.com");
        var user3 = new User(4, "Raza", "raza@gmail.com");

        Stackoverflow.getInstance().users.add(user1);
        Stackoverflow.getInstance().users.add(user2);

        var tags = new HashSet<>(Arrays.asList("C#", "Hello, World!"));
        Stackoverflow.getInstance().activities.add(new Question(1, "Hello, World! In C#", "What is wrong with my code", user1, tags));

        var result = Stackoverflow.getInstance().findQuestionById(1);
        if(result.isPresent()) {
            Question question = (Question) result.get();
            System.out.println(question);

            question.addComment(new Comment(4, "Are you serious?", user3));

            System.out.println("Question Comments: " + question.getCommentById(4));

            question.upVote(user2);

            System.out.println("Question vote " + question.getVote());
            System.out.println("Question poster reputation " + question.getUser().getReputation());

            question.addAnswer(new Answer(3, "You forgot to add semi-colon at the end.", user2));
            Answer answer = question.getAnswerById(3);
            answer.upVote(user1);

            System.out.println("Answer vote " + answer.getVote());
            System.out.println("Answer poster reputation " + answer.getUser().getReputation());

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
        }
    }
}
