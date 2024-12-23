package org.lld.linkedin;

import java.util.List;

public class LinkedInService {
    private static LinkedInService instance;

    public static LinkedInService getInstance() {
        if (instance == null) {
            instance = new LinkedInService();
        }

        return instance;
    }

    private LinkedInService() {
    }

    public void registerAccount(Account account) {
        AccountService.getInstance().addAccount(account);
    }

    public void removeAccount(Account account) {
        AccountService.getInstance().removeAccount(account);
    }

    public void addPost(Post post) {
        PostService.getInstance().addPost(post);
    }

    public void removePost(Post post) {
        PostService.getInstance().removePost(post.getId());
    }

    public void sendConnectionRequest(Connection connection) {
        ConnectionService.getInstance().sendConnectionRequest(connection);
    }

    public void acceptConnectionRequest(Connection connection) {
        ConnectionService.getInstance().acceptConnectionRequest(connection);
    }

    public void removeConnection(Connection connection) {
        ConnectionService.getInstance().removeConnection(connection);
    }

    public void sendMessage(Message message) {
        MessageService.getInstance().sendMessage(message);
    }

    public List<Message> getUnreadMessages(Account account) {
        return MessageService.getInstance().getAccountUnreadMessages(account);
    }

    public List<Message> getConnectionInbox(Connection connection) {
        return MessageService.getInstance().getConnectionInbox(connection);
    }

    public List<Notification> getAccountNotifications(Account account) {
        return NotificationService.getInstance().getNotificationsByAccount(account);
    }

    public void clearAccountNotifications(Account account) {
        NotificationService.getInstance().markAllAccountNotificationsAsRead(account);
    }
}
