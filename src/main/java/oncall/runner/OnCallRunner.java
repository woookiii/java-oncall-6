package oncall.runner;

import oncall.controller.MonthDayController;
import oncall.controller.OnCallOrderController;
import oncall.domain.MonthDay;
import oncall.domain.OnCallOrder;

public class OnCallRunner {
    private final MonthDayController monthDayController = new MonthDayController();
    private final OnCallOrderController onCallOrderController = new OnCallOrderController();

    public void run() {
        MonthDay monthDay = monthDayController.repeatGetMonthDayUntilRight();
        OnCallOrder oncallOrder = onCallOrderController.repeatGetOnCallOrderUntilRight();
    }
}
