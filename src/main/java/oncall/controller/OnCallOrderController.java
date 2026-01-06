package oncall.controller;

import camp.nextstep.edu.missionutils.Console;
import oncall.domain.OnCallOrder;
import oncall.enumeration.GuideMessage;
import oncall.validator.OnCallOrderValidator;

import java.util.List;

public class OnCallOrderController {
    OnCallOrderValidator onCallOrderValidator = new OnCallOrderValidator();

    public OnCallOrder repeatGetOnCallOrderUntilRight() {
        OnCallOrder onCallOrder;
        while(true) {
            try{
                onCallOrder = getInput();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return onCallOrder;
    }

    private OnCallOrder getInput() {
        System.out.print(GuideMessage.WEEKDAY.getMessage());
        String weekDayInput = Console.readLine();
        List<String> weekDayOrder = List.of(weekDayInput.split(","));
        onCallOrderValidator.isWeekDayInputSizeRight(weekDayOrder);
        onCallOrderValidator.isNickNameNotRedundant(weekDayOrder);
        onCallOrderValidator.isWeekDayInputNickNameLengthValid(weekDayOrder);
        System.out.print(GuideMessage.MONTH_DAY.getMessage());
        String restDayInput = Console.readLine();
        List<String> restDayOrder = List.of(restDayInput.split(","));
        onCallOrderValidator.compareOrders(restDayOrder, weekDayOrder);
        return new OnCallOrder(weekDayOrder, restDayOrder);
    }
}

