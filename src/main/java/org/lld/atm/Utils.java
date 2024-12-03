package org.lld.atm;

public class Utils {
    private static int ID = 0;

    public static int getID() {
        return ++ID;
    }
}
