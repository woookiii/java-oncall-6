package oncall.controller;

import camp.nextstep.edu.missionutils.Console;
import oncall.domain.MonthDay;
import oncall.enumeration.GuideMessage;
import oncall.validator.MonthDayValidator;

import java.util.List;

public class MonthDayController {
    private final MonthDayValidator monthDayValidator = new MonthDayValidator();

    public MonthDay repeatGetMonthDayUntilRight() {
        MonthDay monthDay;
        while (true) {
            try {
                monthDay = getInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private MonthDay getInput() {
        System.out.print(GuideMessage.MONTH_DAY);
        String monthAndDayOfWeek = Console.readLine();
        List<String> a = List.of(monthAndDayOfWeek.split(","));
    }
}
