package oncall.runner;

import oncall.controller.MonthDayController;
import oncall.controller.OnCallOrderController;
import oncall.domain.MonthDay;
import oncall.domain.OnCallOrder;
import oncall.printer.TablePrinter;
import oncall.service.OnCallService;

import java.util.List;

public class OnCallRunner {
    private final MonthDayController monthDayController = new MonthDayController();
    private final OnCallOrderController onCallOrderController = new OnCallOrderController();
    private final OnCallService onCallOrderService = new OnCallService();
    private final TablePrinter tablePrinter = new TablePrinter();

    public void run() {
        MonthDay monthDay = monthDayController.repeatGetMonthDayUntilRight();
        OnCallOrder onCallOrder = onCallOrderController.repeatGetOnCallOrderUntilRight();
        List<String> table = onCallOrderService.makeTable(monthDay, onCallOrder);
        tablePrinter.print(table, monthDay);
    }
}
