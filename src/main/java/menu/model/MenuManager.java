package menu.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuManager {
	private Map<DayOfWeek, MenuCategory> recommendedCategories = new HashMap<>();

	public MenuManager() {
		recommendCategories();
	}

	private void recommendCategories() {
		final int MAX_RECOMMEND_RANGE = 2;

		for (DayOfWeek day : DayOfWeek.values()) {
			MenuCategory category = MenuCategory.get(Randoms.pickNumberInRange(1, 5));
			if (Collections.frequency(recommendedCategories.values(), category) == MAX_RECOMMEND_RANGE) {
				category = MenuCategory.get(Randoms.pickNumberInRange(1, 5));
			}
			recommendedCategories.put(day, category);
		}
	}

	public void recommendMenus() {
		CoachRepository coachRepository = new CoachRepository();
		for (DayOfWeek day : DayOfWeek.values()) {
			List<Coach> coaches = coachRepository.findAll();
			for (Coach coach : coaches) {
				MenuCategory todaysCategory = recommendedCategories.get(day);
				String recommendedMenu = recommendMenuByCategory(coach, todaysCategory);
				coach.recommendedMenus(day, recommendedMenu);
			}
		}
	}

	private String recommendMenuByCategory(Coach coach, MenuCategory todaysCategory) {
		String recommendedMenu = Randoms.shuffle(Menu.getMenuBy(todaysCategory)).get(0);
		if (coach.isAvoidFood(recommendedMenu)) {
			recommendedMenu = Randoms.shuffle(Menu.getMenuBy(todaysCategory)).get(0);
		}
		return recommendedMenu;
	}

	public Map<DayOfWeek, MenuCategory> getRecommendedCategories() {
		return recommendedCategories;
	}
}
