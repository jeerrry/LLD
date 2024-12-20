package org.lld.linkedin;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class ConnectionService {
    private static ConnectionService instance;

    public static ConnectionService getInstance() {
        if (instance == null) {
            instance = new ConnectionService();
        }
        return instance;
    }

    private ConnectionService() {
    }

    private final ConcurrentHashMap<User, HashMap<User, Connection>> connections = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<User, Set<Connection>> connectionRequests = new ConcurrentHashMap<>();

    public boolean sendConnectionRequest(Connection connection) {
        if (isConnectionRequestAlreadySent(connection)) {
            System.out.println("Connection request already sent");
            return false;
        }

        Set<Connection> userConnectionRequests = connectionRequests.getOrDefault(connection.getReceiver(), new HashSet<>());
        userConnectionRequests.add(connection);
        NotificationService.getInstance()
                .sendNotification(
                        new Notification("New Connection Request from " + connection.getSender().getName(),
                                connection.getSender(), connection.getReceiver(), NotificationType.CONNECTION));

        return true;
    }

    public boolean acceptConnectionRequest(Connection connection) {
        if (isConnectionAlreadyMade(connection)) {
            System.out.println("Both users already connected");
            return false;
        }

        Set<Connection> requests = connectionRequests.getOrDefault(connection.getReceiver(), new HashSet<>());
        requests.remove(connection);
        connection.setConnectionStatus(true);

        HashMap<User, Connection> sender = connections.getOrDefault(connection.getSender(), new HashMap<>());
        HashMap<User, Connection> receiver = connections.getOrDefault(connection.getReceiver(), new HashMap<>());

        sender.put(connection.getReceiver(), connection);
        receiver.put(connection.getSender(), connection);


        NotificationService.getInstance()
                .sendNotification(
                        new Notification("Congratulation on getting connected with " + connection.getReceiver().getName(),
                                connection.getReceiver(),
                                connection.getSender(),
                                NotificationType.CONNECTION));
        NotificationService.getInstance()
                .getNotificationByType(connection.getSender(), NotificationType.CONNECTION)
                .stream().filter(x -> x.getReceiver().equals(connection.getReceiver()))
                .forEach(x -> x.setNotificationStatus(true));

        return true;
    }

    private boolean isConnectionRequestAlreadySent(Connection connection) {
        Set<Connection> senderBuffer = connectionRequests.getOrDefault(connection.getSender(), new HashSet<>());
        Set<Connection> receiverBuffer = connectionRequests.getOrDefault(connection.getReceiver(), new HashSet<>());

        return senderBuffer.contains(connection) || receiverBuffer.contains(connection);
    }

    private boolean isConnectionAlreadyMade(Connection connection) {
        // Since the connection graph is bidirectional we can rely on sender containing connection to target.
        HashMap<User, Connection> sender = connections.getOrDefault(connection.getSender(), new HashMap<>());

        return sender.containsKey(connection.getReceiver());
    }

    public Set<Connection> getConnectionRequests(User user) {
        return connectionRequests.getOrDefault(user, new HashSet<>());
    }

    public List<User> getConnections(User user) {
        return connections.getOrDefault(user, new HashMap<>()).keySet().stream().toList();
    }
}
