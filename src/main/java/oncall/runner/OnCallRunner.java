package oncall.runner;

import oncall.controller.MonthDayController;
import oncall.controller.OnCallOrderController;
import oncall.domain.MonthDay;
import oncall.domain.OnCallOrder;
import oncall.service.OnCallService;

import java.util.List;

public class OnCallRunner {
    private final MonthDayController monthDayController = new MonthDayController();
    private final OnCallOrderController onCallOrderController = new OnCallOrderController();
    private final OnCallService onCallOrderService = new OnCallService();

    public void run() {
        MonthDay monthDay = monthDayController.repeatGetMonthDayUntilRight();
        OnCallOrder onCallOrder = onCallOrderController.repeatGetOnCallOrderUntilRight();
        List<String> table = onCallOrderService.makeTable(monthDay, onCallOrder);
        System.out.println(table);
        System.out.println(table.size());
    }
}
