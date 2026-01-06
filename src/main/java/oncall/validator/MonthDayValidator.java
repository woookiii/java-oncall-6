package oncall.validator;

import oncall.enumeration.Day;
import oncall.enumeration.GuideMessage;
import oncall.enumeration.Month;

import java.util.List;

public class MonthDayValidator {
    private static final int JANUARY = 1;
    private static final int DECEMBER = 12;

    public void isInputSizeRight(List<String> splitMonthDay) {
        if(splitMonthDay.size() != 2) {
            throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
        }
    }

    public Month parseMonth(String monthInput) {
        if(monthInput.equals(String.valueOf(Month.JANUARY.getMonth()))) return Month.JANUARY;
        if(monthInput.equals(String.valueOf(Month.FEBURARY.getMonth()))) return Month.FEBURARY;
        if(monthInput.equals(String.valueOf(Month.MARCH.getMonth()))) return Month.MARCH;
        if(monthInput.equals(String.valueOf(Month.APRIL.getMonth()))) return Month.APRIL;
        if(monthInput.equals(String.valueOf(Month.MAY.getMonth()))) return Month.MAY;
        if(monthInput.equals(String.valueOf(Month.JUNE.getMonth()))) return Month.JUNE;
        if(monthInput.equals(String.valueOf(Month.JULY.getMonth()))) return Month.JULY;
        if(monthInput.equals(String.valueOf(Month.AUGUST.getMonth()))) return Month.AUGUST;
        if(monthInput.equals(String.valueOf(Month.SEPTEMBER.getMonth()))) return Month.SEPTEMBER;
        if(monthInput.equals(String.valueOf(Month.OCTOBER.getMonth()))) return Month.OCTOBER;
        if(monthInput.equals(String.valueOf(Month.NOVEMBER.getMonth()))) return Month.NOVEMBER;
        if(monthInput.equals(String.valueOf(Month.DECEMBER.getMonth()))) return Month.DECEMBER;

        throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
    }

    public Day parseDay(String dayInput) {
        if(dayInput.equals(Day.MONDAY.getDay())) return Day.MONDAY;
        if(dayInput.equals(Day.TUESDAY.getDay())) return Day.TUESDAY;
        if(dayInput.equals(Day.WEDNESDAY.getDay())) return Day.WEDNESDAY;
        if(dayInput.equals(Day.THURSDAY.getDay())) return Day.THURSDAY;
        if(dayInput.equals(Day.FRIDAY.getDay())) return Day.FRIDAY;
        if(dayInput.equals(Day.SATURDAY.getDay())) return Day.SATURDAY;
        if(dayInput.equals(Day.SUNDAY.getDay())) return Day.SUNDAY;

        throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
    }
}
