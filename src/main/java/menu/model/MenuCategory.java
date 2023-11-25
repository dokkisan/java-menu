package menu.model;

public enum MenuCategory {
	KOREAN(1, "한식"),
	JAPANESE(2, "일식"),
	CHINESE(3, "중식"),
	ASIAN(4, "아시안"),
	WESTERN(5, "양식");

	private final int index;
	private final String name;

	MenuCategory(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public static MenuCategory get(int index) {
		for (MenuCategory category : MenuCategory.values()) {
			if (category.index == index) {
				return category;
			}
		}
		throw new IllegalArgumentException();
	}

	public String getName() {
		return name;
	}
}
