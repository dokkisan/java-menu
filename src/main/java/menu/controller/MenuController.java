package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menu.model.Coach;
import menu.model.DayOfWeek;
import menu.model.MenuCategory;
import menu.message.OperationMessage;
import menu.model.MenuManager;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
	private final InputView inputView;
	private final OutputView outputView;

	public MenuController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		List<String> names = getCoachNames();
		Map<String, Coach> coaches = getAvoidFoods(names);
		viewMenuRecommendationResult();
	}

	private List<String> getCoachNames() {
		outputView.printMessage(OperationMessage.INPUT_NAMES.getMessage());
		while (true) {
			try {
				return inputView.inputNames();
			} catch (IllegalArgumentException e) {
				outputView.printMessage(e.getMessage());
			}
		}
	}

	private Map<String, Coach> getAvoidFoods(List<String> names) {
		Map<String, Coach> coaches = new HashMap<>();
		for (String name : names) {
			outputView.printMessage(name + OperationMessage.INPUT_AVOID_FOODS.getMessage());
			List<String> avoidFoods = inputView.inputAvoidFoods();
			coaches.put(name, new Coach(name, avoidFoods));
		}
		return coaches;
	}

	private void viewMenuRecommendationResult() {
		MenuManager menuManager = new MenuManager();
		outputView.printMessage(OperationMessage.RECOMMEND_RESULT.getMessage());
		outputView.printListWithJoining(createLunchDaysForView());
		outputView.printListWithJoining(createCategoriesForView(menuManager.getRecommendedCategories()));
		outputView.printBlankLine();
		outputView.printMessage(OperationMessage.RECOMMEND_SUCCESS.getMessage());
	}

	private List<String> createCategoriesForView(List<MenuCategory> result) {
		final String CATEGORY_PREFIX = "카테고리";
		List<String> categoryNames = new ArrayList<>();
		categoryNames.add(CATEGORY_PREFIX);
		for (MenuCategory category : result) {
			categoryNames.add(category.getName());
		}
		return categoryNames;
	}

	private List<String> createLunchDaysForView() {
		List<String> days = new ArrayList<>();
		for (DayOfWeek day : DayOfWeek.values()) {
			days.add(day.getName());
		}
		return days;
	}

	// private void viewRecommendationMenus() {
	// 	MenuManager menuManager = new MenuManager();
	// 	Map<String, List<String>> menus = menuManager.getRecommendedMenusResult();
	// 	for (Map.Entry<String, List<String>> menu : menus.entrySet()) {
	// 		List<String> recommendationMenus = new ArrayList<>();
	// 		recommendationMenus.add(menu.getKey());
	// 		recommendationMenus.add(String.valueOf(menu));
	// 	}
	// 	outputView.printListWithJoining();
	// }
}
