package menu.message;

public enum ErrorMessage {
    NAME_SEPARATOR_ERROR("코치의 이름은 쉼표(, )로 구분해 입력해주세요."),
    MIN_NAME_COUNT_ERROR("코치는 최소 2명 이상 입력해야 합니다."),
    MAX_NAME_COUNT_ERROR("코치는 최대 5명 이하 입력해야 합니다."),
    MIN_NAME_LENGTH_ERROR("코치 이름은 최소 2글자 이상이어야 합니다."),
    MAX_NAME_LENGTH_ERROR("코치 이름은 최대 5글자 이하여야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        final String PREFIX = "[ERROR] ";
        return PREFIX + message;
    }
}
