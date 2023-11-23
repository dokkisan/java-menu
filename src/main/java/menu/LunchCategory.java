package menu;

public enum LunchCategory {
    CATEGORY("카테고리"),
    KOREAN("한식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    ASIAN("아시안");

    private final String category;

    LunchCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
