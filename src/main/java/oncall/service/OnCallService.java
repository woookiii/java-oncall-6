package oncall.service;

import oncall.domain.MonthDay;
import oncall.domain.OnCallOrder;

import java.util.*;

public class OnCallService {

    public List<String> makeTable(MonthDay monthDay, OnCallOrder onCallOrder) {
        int dayIndex = monthDay.day().getIndex();
        final Queue<String> w = new LinkedList<>(onCallOrder.weekday());
        final Queue<String> r = new LinkedList<>(onCallOrder.restDay());
        addEnoughEntry(r, onCallOrder.restDay());
        addEnoughEntry(w, onCallOrder.weekday());
        String lastWorker = "";

        return build(monthDay, w, r, lastWorker, dayIndex);
    }

    private List<String> build(MonthDay monthDay, Queue<String> w, Queue<String> r, String lastWorker, int dayIndex) {
        final List<String> table = new ArrayList<>();
        for (int i = 1; i <= monthDay.month().getLength(); i++) {
            if (dayIndex == 5 || dayIndex == 6 || monthDay.month().getHoliday().contains(i)) {
                lastWorker = chooseDayWorker(r, lastWorker, table);
                dayIndex = getNextIndex(dayIndex);
                continue;
            }
            lastWorker = chooseDayWorker(w, lastWorker, table);
            dayIndex = getNextIndex(dayIndex);
        }
        return table;
    }

    private static String chooseDayWorker(Queue<String> r, String lastWorker, List<String> table) {
        String rCandidate = r.poll();
        assert rCandidate != null;
        if (!rCandidate.equals(lastWorker)) {
            table.add(rCandidate);
            lastWorker = rCandidate;
            return lastWorker;
        }
        String rNext = r.poll();
        r.add(rCandidate);
        table.add(rNext);
        lastWorker = rNext;
        return lastWorker;
    }

    private static void addEnoughEntry(Queue<String> r, List<String> order) {
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
        r.addAll(order);
    }


    private int getNextIndex(int index) {
        if (++index == 7) {
            index = 0;
        }
        return index;
    }

}
