package oncall.enumeration;

public enum GuideMessage {
    MONTH_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    ERROR("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    WEEKDAY("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    WEEKEND_AND_HOLIDAY("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    ;

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
