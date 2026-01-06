package oncall.domain;

import oncall.enumeration.Day;
import oncall.enumeration.Month;

public record MonthDay(
        Month month,
        Day day
) {
}