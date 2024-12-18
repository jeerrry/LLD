package org.lld.linkedin;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionService {
    private ConcurrentHashMap<User, HashMap<User, Connection>> connections = new ConcurrentHashMap<>();
    private ConcurrentHashMap<User, Set<Connection>> connectionRequests = new ConcurrentHashMap<>();

    public boolean sendConnectionRequest(Connection connection) {
        if (isConnectionRequestAlreadySent(connection)) {
            System.out.println("Connection request already sent");
            return false;
        }

        Set<Connection> userConnectionRequests = connectionRequests.getOrDefault(connection.getUser2(), new HashSet<>());
        userConnectionRequests.add(connection);

        return true;
    }

    public boolean acceptConnectionRequest(Connection connection) {
        if (isConnectionAlreadyMade(connection)) {
            System.out.println("Both users already connected");
            return false;
        }

        Set<Connection> requests = connectionRequests.getOrDefault(connection.getUser2(), new HashSet<>());
        requests.remove(connection);
        connection.setConnectionStatus(true);

        HashMap<User, Connection> sender = connections.getOrDefault(connection.getUser1(), new HashMap<>());
        HashMap<User, Connection> receiver = connections.getOrDefault(connection.getUser2(), new HashMap<>());

        sender.put(connection.getUser2(), connection);
        receiver.put(connection.getUser1(), connection);

        return true;
    }

    private boolean isConnectionRequestAlreadySent(Connection connection) {
        Set<Connection> senderBuffer = connectionRequests.getOrDefault(connection.getUser1(), new HashSet<>());
        Set<Connection> receiverBuffer = connectionRequests.getOrDefault(connection.getUser2(), new HashSet<>());

        return senderBuffer.contains(connection) || receiverBuffer.contains(connection);
    }

    private boolean isConnectionAlreadyMade(Connection connection) {
        HashMap<User, Connection> sender = connections.getOrDefault(connection.getUser1(), new HashMap<>());
        HashMap<User, Connection> receiver = connections.getOrDefault(connection.getUser2(), new HashMap<>());

        return sender.containsKey(connection.getUser2()) && receiver.containsKey(connection.getUser1());
    }

    public Set<Connection> getConnectionRequests(User user) {
        return connectionRequests.getOrDefault(user, new HashSet<>());
    }

    public List<User> getConnections(User user) {
        return connections.getOrDefault(user, new HashMap<>()).keySet().stream().toList();
    }
}
