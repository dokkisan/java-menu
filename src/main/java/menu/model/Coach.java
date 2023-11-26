package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
	private final String name;
	private List<String> avoidMenus;
	private Map<DayOfWeek, String> recommendedMenus;

	public Coach(String name) {
		this.name = name;
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

	public Map<DayOfWeek, String> getRecommendedMenus() {
		return recommendedMenus;
	}

	// TODO: 이름 글자수 2-4 유효성 검사
}
