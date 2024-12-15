package org.lld.hotelmanagementsystem;

import java.time.LocalDate;

public class Utils {
    private static int id = 1;

    public static int getId() {
        return id++;
    }

    public static boolean datesOverlap(LocalDate startDate1, LocalDate endDate1, LocalDate startDate2, LocalDate endDate2) {
        var smaller = new LocalDate[]{startDate1, endDate1};
        var bigger = new LocalDate[]{startDate2, endDate2};
        if (startDate2.isBefore(startDate1)) {
            bigger = smaller;
            smaller = new LocalDate[]{startDate2, endDate2};
        }

        return smaller[1].isAfter(bigger[0]);
    }
}
