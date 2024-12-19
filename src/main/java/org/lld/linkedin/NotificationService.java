package org.lld.linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class NotificationService {
    private static NotificationService instance;

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    private NotificationService() {
    }

    private final ConcurrentHashMap<User, ArrayList<Notification>> notifications = new ConcurrentHashMap<>();

    public boolean sendNotification(Notification notification) {
        ArrayList<Notification> notificationList = notifications.getOrDefault(notification.getReceiver(), new ArrayList<>());
        notificationList.add(notification);

        return true;
    }

    public List<Notification> getNotificationsByUser(User user) {
        return notifications.getOrDefault(user, new ArrayList<>()).stream().filter(x -> !x.isRead()).toList();
    }

    public boolean markNotificationAsReadById(int notificationId) {
        Notification target = null;
        for (List<Notification> notificationList : notifications.values()) {
            target = notificationList.stream().filter(x -> x.getId() == notificationId).findFirst().orElse(null);
            if (target != null) {
                break;
            }
        }

        if (target != null) {
            target.setNotificationStatus(true);
            return true;
        }
        return false;
    }

    public boolean markAllUserNotificationsAsRead(User user) {
        List<Notification> notifications = getNotificationsByUser(user);
        for (Notification notification : notifications) {
            notification.setNotificationStatus(true);
        }

        return true;
    }
}
