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

    private final ConcurrentHashMap<User, PriorityQueue<Message>> messages = new ConcurrentHashMap<>();

    public boolean sendMessage(final User user, final Message message) {
        PriorityQueue<Message> inbox = messages.getOrDefault(user, new PriorityQueue<>((x, y) -> y.getId() - x.getId()));

        inbox.add(message);
        return true;
    }

    public List<Message> getUserUnreadMessages(final User user) {
        PriorityQueue<Message> inbox = messages.getOrDefault(user, new PriorityQueue<>());
        return inbox.stream().filter(x -> !x.isRead()).sorted((x, y) -> y.getId() - x.getId()).toList();
    }

    public List<Message> getConnectionInbox(final Connection connection) {
        PriorityQueue<Message> sender = messages.getOrDefault(connection.getUser1(), new PriorityQueue<>());
        PriorityQueue<Message> receiver = messages.getOrDefault(connection.getUser2(), new PriorityQueue<>());

        List<Message> inbox = new java.util.ArrayList<>(sender.stream().filter(x -> x.getReceiver().equals(connection.getUser2())).toList());
        inbox.addAll(receiver.stream().filter(x -> x.getReceiver().equals(connection.getUser1())).toList());
        inbox.sort((x, y) -> y.getId() - x.getId());

        return inbox;
    }
}
