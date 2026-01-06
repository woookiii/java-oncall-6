package oncall.validator;

import oncall.enumeration.GuideMessage;

import java.util.*;

public class OnCallOrderValidator {

    public void isWeekDayInputSizeRight(List<String> splitWeekDayInput) {
        if (splitWeekDayInput.size() < 5 || splitWeekDayInput.size() > 35) {
            throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
        }
    }

    public void isNickNameNotRedundant(List<String> order) {
        if (new HashSet<>(order).size() != order.size()) {
            throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
        }
    }

    public void isWeekDayInputNickNameLengthValid(List<String> splitWeekDayInput) {
        for (String nickName : splitWeekDayInput) {
            isNickNameLengthValid(nickName);
        }
    }

    private void isNickNameLengthValid(String nickName) {
        if (nickName.length() > 5) {
            throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
        }
    }

    public void compareOrders(List<String> restDayOrder, List<String> weekDayOrder) {
        if(new HashSet<>(restDayOrder).size() != weekDayOrder.size()) {
            throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
        }
        for(String worker : weekDayOrder) {
            checkWorkerInOrder(restDayOrder, worker);
        }
    }

    private void checkWorkerInOrder(List<String> restDayOrder, String worker) {
        if(!restDayOrder.contains(worker)) {
            throw new IllegalArgumentException(GuideMessage.ERROR.getMessage());
        }
    }
}
