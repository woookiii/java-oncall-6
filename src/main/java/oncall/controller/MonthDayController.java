package oncall.controller;

import camp.nextstep.edu.missionutils.Console;
import oncall.domain.MonthDay;
import oncall.enumeration.Day;
import oncall.enumeration.GuideMessage;
import oncall.enumeration.Month;
import oncall.validator.MonthDayValidator;

import java.util.List;

public class MonthDayController {
    private final MonthDayValidator monthDayValidator = new MonthDayValidator();

    public MonthDay repeatGetMonthDayUntilRight() {
        MonthDay monthDay;
        while (true) {
            try {
                monthDay = getInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return monthDay;
    }

    private MonthDay getInput() {
        System.out.print(GuideMessage.MONTH_DAY.getMessage());
        String monthDayInput = Console.readLine();
        List<String> splitMonthDay = List.of(monthDayInput.split(","));
        monthDayValidator.isInputSizeRight(splitMonthDay);
        final Month month = monthDayValidator.parseMonth(splitMonthDay.get(0));
        final Day day = monthDayValidator.parseDay(splitMonthDay.get(1));
        return new MonthDay(month, day);
    }
}
