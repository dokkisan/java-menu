package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menu.message.ErrorMessage;

public class Coach {
	private final String name;
	private List<String> avoidMenus;
	private Map<DayOfWeek, String> recommendedMenus;

	public Coach(String name) {
		this.name = validateNameLength(name);
		this.avoidMenus = new ArrayList<>();
		this.recommendedMenus = new HashMap<>();
		for (DayOfWeek day : DayOfWeek.values()) {
			recommendedMenus.put(day, "");
		}
	}

	public boolean isAvoidFood(String menu) {
		return avoidMenus.stream().anyMatch(menu::equals);
	}

	public String getName() {
		return name;
	}

	// TODO: setter 삭제
	public void setAvoidMenus(List<String> avoidMenus) {
		this.avoidMenus = avoidMenus;
	}

	public void recommendedMenus(DayOfWeek day, String menu) {
		recommendedMenus.put(day, menu);
	}

	public boolean isRecommendedMenu(String menu) {
		return recommendedMenus.containsValue(menu);
	}

	public Map<DayOfWeek, String> getRecommendedMenus() {
		return recommendedMenus;
	}

	private String validateNameLength(String name) {
		final int MIN_NAME_LENGTH = 2;
		final int MAX_NAME_LENGTH = 4;

		if (name.length() < MIN_NAME_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.MIN_NAME_LENGTH_ERROR.getMessage());
		}
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.MAX_NAME_LENGTH_ERROR.getMessage());
		}
		return name;
	}
}
