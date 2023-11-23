package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import menu.DayOfWeek;
import menu.MenuCategory;

public class MenuManager {

	public List<MenuCategory> recommendCategories() {
		List<MenuCategory> categories = new ArrayList<>();
		for (int i = 0; i < DayOfWeek.values().length; i++) {
			categories.add(MenuCategory.get(Randoms.pickNumberInRange(1, 5)));
		}
		return categories;
	}
}
