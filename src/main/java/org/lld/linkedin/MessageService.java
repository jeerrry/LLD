package org.lld.linkedin;

import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class MessageService {
    public static MessageService instance;

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    private MessageService() {
    }

    private final ConcurrentHashMap<Account, PriorityQueue<Message>> messages = new ConcurrentHashMap<>();

    public boolean sendMessage(final Message message) {
        PriorityQueue<Message> inbox = messages.getOrDefault(message.getReceiver(), new PriorityQueue<>((x, y) -> y.getId() - x.getId()));

        inbox.add(message);

        // TODO! Could batch notifications inboxed to the same account for improved performance.
        NotificationService.getInstance().sendNotification(new Notification("New message received from " + message.getSender().getName(), message.getReceiver(), message.getReceiver(), NotificationType.MESSAGE));

        return true;
    }

    public List<Message> getAccountUnreadMessages(final Account account) {
        PriorityQueue<Message> inbox = messages.getOrDefault(account, new PriorityQueue<>());
        NotificationService.getInstance().getNotificationByType(account, NotificationType.MESSAGE).forEach(x -> NotificationService.getInstance().markNotificationAsReadById(x.getId()));

        return inbox.stream().filter(x -> !x.isRead()).sorted((x, y) -> y.getId() - x.getId()).toList();
    }

    public List<Message> getConnectionInbox(final Connection connection) {
        PriorityQueue<Message> sender = messages.getOrDefault(connection.getSender(), new PriorityQueue<>());
        PriorityQueue<Message> receiver = messages.getOrDefault(connection.getReceiver(), new PriorityQueue<>());

        List<Message> inbox = new java.util.ArrayList<>(sender.stream().filter(x -> x.getReceiver().equals(connection.getReceiver())).toList());
        inbox.addAll(receiver.stream().filter(x -> x.getReceiver().equals(connection.getSender())).toList());
        inbox.sort((x, y) -> y.getId() - x.getId());
        inbox.forEach(x -> NotificationService.getInstance().markNotificationAsReadById(x.getId()));

        return inbox;
    }
}
