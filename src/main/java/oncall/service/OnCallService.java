package oncall.service;

import oncall.domain.MonthDay;
import oncall.domain.OnCallOrder;

import java.util.*;

public class OnCallService {

    public List<String> makeTable(MonthDay monthDay, OnCallOrder onCallOrder) {
        int weekdayIndex = 0;
        int restDayIndex = 0;
        int dayIndex = monthDay.day().getIndex();
        final int workerSize = onCallOrder.weekday().size();
        final Queue<String> w = new LinkedList<>(onCallOrder.weekday());
        final Queue<String> r = new LinkedList<>(onCallOrder.restDay());
        addEnoughEntry(r, onCallOrder.restDay());
        addEnoughEntry(w, onCallOrder.weekday());
        String lastWorker = "";

        final List<String> table = new ArrayList<>();
        build(monthDay, dayIndex, r, lastWorker, table, w);
        return table;
    }

    private void build(MonthDay monthDay, int dayIndex, Queue<String> r, String lastWorker, List<String> table, Queue<String> w) {
        for (int i = 1; i <= monthDay.month().getLength(); i++) {
            if (dayIndex == 5 || dayIndex == 6 || monthDay.month().getHoliday().contains(i)) {
                lastWorker = chooseDayWorker(r, lastWorker, table);
                continue;
            }
            String wCandidate = w.poll();
            if(!wCandidate.equals(lastWorker)){
                table.add(wCandidate);
                lastWorker = wCandidate;
                continue;
            }
            String wNext = w.poll();
            w.add(wCandidate);
            table.add(wNext);
            lastWorker = wNext;

            dayIndex = getNextIndex(dayIndex, 6);
        }
    }

    private static String chooseDayWorker(Queue<String> r, String lastWorker, List<String> table) {
        String rCandidate = r.poll();
        if(!rCandidate.equals(lastWorker)){
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



    private int getNextIndex(int index, int size) {
        if (++index == size) {
            index = 0;
        }
        return index;
    }

}
