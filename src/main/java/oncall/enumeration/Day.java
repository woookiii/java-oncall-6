package oncall.enumeration;

public enum Day {
    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    private final String day;
    private final int index;

    Day(String day, int index) {
        this.day = day;
        this.index = index;
    }

    public String getDay() {
        return day;
    }

    public int getIndex() {
        return index;
    }
}
