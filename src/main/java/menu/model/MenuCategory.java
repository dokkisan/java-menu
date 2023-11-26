package menu.model;

public enum MenuCategory {
	JAPANESE(1, "일식"),
	KOREAN(2, "한식"),
	CHINESE(3, "중식"),
	ASIAN(4, "아시안"),
	WESTERN(5, "양식");

	private final int id;
	private final String name;

	MenuCategory(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static MenuCategory get(int index) {
		for (MenuCategory category : MenuCategory.values()) {
			if (category.id == index) {
				return category;
			}
		}
		throw new IllegalArgumentException();
	}

	public String getName() {
		return name;
	}
}
