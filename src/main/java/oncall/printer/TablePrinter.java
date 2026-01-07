package oncall.printer;

import oncall.domain.MonthDay;

import java.util.ArrayList;
import java.util.List;

public class TablePrinter {
    private final static List<String> DAYS_OF_WEEK = new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일"));

    public void print(List<String> table, MonthDay monthDay) {
        int dayIndex = monthDay.day().getIndex();
        for (int i = 1; i <= monthDay.month().getLength(); i++) {
            if(monthDay.month().getHoliday().contains(i)) {
                System.out.println(monthDay.month().getMonth()+"월 "+i+"일 "+ DAYS_OF_WEEK.get(dayIndex)+"(휴일) "+ table.get(i-1));
                continue;
            }
            System.out.println(monthDay.month().getMonth()+"월 " +i+"일 "+ DAYS_OF_WEEK.get(dayIndex)+ " " + table.get(i-1));
            dayIndex = getNextIndex(dayIndex);
        }
    }

    private int getNextIndex(int index) {
        if (++index == 7) {
            index = 0;
        }
        return index;
    }
}
