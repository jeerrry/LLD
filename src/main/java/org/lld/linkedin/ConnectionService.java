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

    private final ConcurrentHashMap<Account, HashMap<Account, Connection>> connections = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Account, Set<Connection>> connectionRequests = new ConcurrentHashMap<>();

    public boolean sendConnectionRequest(Connection connection) {
        if (isConnectionRequestAlreadySent(connection)) {
            System.out.println("Connection request already sent");
            return false;
        }

        Set<Connection> accountConnectionRequests = connectionRequests.getOrDefault(connection.getReceiver(), new HashSet<>());
        accountConnectionRequests.add(connection);
        connectionRequests.put(connection.getReceiver(), accountConnectionRequests);
        NotificationService.getInstance()
                .sendNotification(
                        new Notification("New Connection Request from " + connection.getSender().getName(),
                                connection.getSender(), connection.getReceiver(), NotificationType.CONNECTION));

        return true;
    }

    public boolean removeConnection(Connection connection) {
        if (connection.getSender() == null || connection.getReceiver() == null) {
            return false;
        }

        if (!isConnectionAlreadyMade(connection)) {
            System.out.println("Cannot remove a non-existent connection");
            return false;
        }

        // Bi-directional graph
        connections.get(connection.getSender()).remove(connection.getReceiver());
        connections.get(connection.getReceiver()).remove(connection.getSender());

        return true;
    }

    public boolean removeConnectionRequest(Connection connection) {
        if (!isConnectionRequestAlreadySent(connection)) {
            System.out.println("Cannot remove non-existent connection request");
            return false;
        }

        connectionRequests.get(connection.getReceiver()).remove(connection);
        System.out.println("Connection request removed");
        return true;
    }

    public boolean acceptConnectionRequest(Connection connection) {
        if (isConnectionAlreadyMade(connection)) {
            System.out.println("Both accounts already connected");
            return false;
        }

        Set<Connection> requests = connectionRequests.getOrDefault(connection.getReceiver(), new HashSet<>());
        requests.remove(connection);
        connection.setConnectionStatus(true);

        HashMap<Account, Connection> sender = connections.getOrDefault(connection.getSender(), new HashMap<>());
        HashMap<Account, Connection> receiver = connections.getOrDefault(connection.getReceiver(), new HashMap<>());

        sender.put(connection.getReceiver(), connection);
        receiver.put(connection.getSender(), connection);

        connections.put(connection.getSender(), sender);
        connections.put(connection.getReceiver(), receiver);

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
        HashMap<Account, Connection> sender = connections.getOrDefault(connection.getSender(), new HashMap<>());

        return sender.containsKey(connection.getReceiver());
    }

    public Set<Connection> getConnectionRequests(Account account) {
        return connectionRequests.getOrDefault(account, new HashSet<>());
    }

    public List<Account> getConnections(Account account) {
        return connections.getOrDefault(account, new HashMap<>()).keySet().stream().toList();
    }
}
