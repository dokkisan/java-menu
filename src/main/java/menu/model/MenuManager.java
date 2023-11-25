package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuManager {
	private List<MenuCategory> recommendedCategories;
	private Map<String, List<String>> recommendedMenusResult;

	public List<MenuCategory> getRecommendedCategories() {
		return recommendedCategories;
	}

	public Map<String, List<String>> getRecommendedMenusResult() {
		return recommendedMenusResult;
	}

	private List<MenuCategory> recommendCategories() {
		for (int i = 0; i < DayOfWeek.values().length; i++) {
			recommendedCategories.add(MenuCategory.get(Randoms.pickNumberInRange(1, 5)));
		}
		return recommendedCategories;
	}

	private void recommendMenu(List<Coach> coaches) {
		for (Coach coach : coaches) {
			List<String> recommendedMenus = new ArrayList<>();
			for (MenuCategory category : recommendedCategories) {
				String recommendedMenu = Randoms.shuffle(Menu.getMenuBy(category)).get(0);
				if (coach.isAvoidFood(recommendedMenu)) {
					recommendedMenu = Randoms.shuffle(Menu.getMenuBy(category)).get(0);
				}
				recommendedMenus.add(recommendedMenu);
			}
			recommendedMenusResult.put(coach.getName(), recommendedMenus);
		}
	}
}
