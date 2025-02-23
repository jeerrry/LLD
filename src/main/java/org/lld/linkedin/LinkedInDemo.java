package org.lld.linkedin;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.lld.linkedin.filter.FilterPredicates;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class LinkedInDemo {
    public static void main(String[] args) {
        var service = LinkedInService.getInstance();

        // User registration
        User user1 = new User("John Doe", "john@example.com", "password", new Profile("", ""));
        User user2 = new User("Jane Smith", "jane@example.com", "password", new Profile("", ""));
        User hiring = new User("RTS", "rts.hiring@example.com", "password", new Profile("", ""));
        service.registerAccount(user1);
        service.registerAccount(user2);
        service.registerAccount(hiring);

        // Update user profile
        user1.getProfile().setHeadline("Software Engineer");
        user1.getProfile().setSummary("Passionate about coding and problem-solving.");

        // Send connection request
        service.sendConnectionRequest(new Connection(user1, user2));
        assertFalse(ConnectionService.getInstance().getConnectionRequests(user2).isEmpty());

        // Accept connection request
        Connection connection = ConnectionService.getInstance().getConnectionRequests(user2).iterator().next();
        ConnectionService.getInstance().acceptConnectionRequest(connection);
        assertTrue(ConnectionService.getInstance().getConnections(user2).stream().anyMatch(c -> c.getId() == user1.getId()));
        assertTrue(ConnectionService.getInstance().getConnections(user1).stream().anyMatch(c -> c.getId() == user2.getId()));

        // Post a job listing
        var jobPosting = new JobPost(Arrays.asList("Java", "Python"), "London", 1000, 2000, hiring, LocalDate.now(), "Senior Software Engineer");
        service.addPost(jobPosting);

        // Search for users
        List<Account> searchResults = SearchService.getInstance().search(AccountService.getInstance().getAccounts(), FilterPredicates.nameFilter("John Doe"));
        System.out.println("Search Results:");
        for (var account : searchResults) {
            User user = (User) account;
            System.out.println("Name: " + user.getName());
            System.out.println("Headline: " + user.getProfile().getHeadline());
            System.out.println();
        }

        // Search for job postings
        List<Post> jobPostingResults = SearchService.getInstance().search(PostService.getInstance().getPosts(), FilterPredicates.descriptionFilter("software"));
        System.out.println("Job Posting Results:");
        for (var posting : jobPostingResults) {
            System.out.println("Description: " + posting.getDescription());
            System.out.println();
        }

        // Send a message
        MessageService.getInstance().sendMessage(new Message(user1, user2, "Hello Jane!"));

        // Get notifications
        List<Notification> notifications = NotificationService.getInstance().getNotificationsByAccount(user2);
        System.out.println("Notifications:");
        for (Notification notification : notifications) {
            System.out.println("Type: " + notification.getType());
            System.out.println("Content: " + notification.getText());
            System.out.println();
        }
    }
}
