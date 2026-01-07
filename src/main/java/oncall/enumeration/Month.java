package oncall.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Month {
    JANUARY(1, 31, new ArrayList<>(List.of(1))),
    FEBURARY(2, 28, new ArrayList<>()),
    MARCH(3, 31, new ArrayList<>(List.of(1))),
    APRIL(4, 30, new ArrayList<>()),
    MAY(5, 31, new ArrayList<>(List.of(5))),
    JUNE(6, 30, new ArrayList<>(List.of(6))),
    JULY(7, 31, new ArrayList<>()),
    AUGUST(8, 31, new ArrayList<>(List.of(15))),
    SEPTEMBER(9, 30, new ArrayList<>()),
    OCTOBER(10, 31, new ArrayList<>(List.of(3, 9))),
    NOVEMBER(11, 30, new ArrayList<>()),
    DECEMBER(12, 31, new ArrayList<>(List.of(25)));

    private final int month;
    private final int length;
    private final List<Integer> holiday;


    Month(int month, int length, List<Integer> holiday) {
        this.month = month;
        this.length = length;
        this.holiday = holiday;
    }


    public int getMonth() {
        return month;
    }

    public int getLength() {
        return length;
    }

    public List<Integer> getHoliday() {
        return holiday;
    }
}
