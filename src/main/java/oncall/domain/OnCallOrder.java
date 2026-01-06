package oncall.domain;

import java.util.List;

public class OnCallOrder {
    private final List<String> weekday;
    private final List<String> restDay;

    public OnCallOrder(List<String> weekday, List<String> restDay) {
        this.weekday = weekday;
        this.restDay = restDay;
    }

    public List<String> getWeekday() {
        return weekday;
    }

    public List<String> getRestDay() {
        return restDay;
    }
}
