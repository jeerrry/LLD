package org.lld.taskmanagementsystem;

public class IDGenerator {
    private static int ID = 1;

    public synchronized static int getID() {
        return ID++;
    }
}
