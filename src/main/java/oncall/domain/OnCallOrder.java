package oncall.domain;

import java.util.List;

public record OnCallOrder(
        List<String> weekday,
        List<String> restDay
) {
}
