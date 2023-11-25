package menu.message;

public enum OperationMessage {
    START_RECOMMEND("점심 메뉴 추천을 시작합니다."),
    INPUT_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_AVOID_FOODS("(이)가 못 먹는 메뉴를 입력해 주세요."),
    RECOMMEND_RESULT("메뉴 추천 결과입니다."),
    RECOMMEND_SUCCESS("추천을 완료했습니다.");

    private final String message;

    OperationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
