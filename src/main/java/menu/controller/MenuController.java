package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import menu.message.OperationMessage;
import menu.model.Coach;
import menu.model.CoachRepository;
import menu.model.DayOfWeek;
import menu.model.MenuCategory;
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
		createCoaches(getCoachNames());
		getAvoidFoods();
		viewMenuRecommendationResult();
	}

	private void createCoaches(List<String> names) {
		CoachRepository coachRepository = new CoachRepository();
		for (String name : names) {
			coachRepository.save(new Coach(name));
		}
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

	private void getAvoidFoods() {
		CoachRepository coachRepository = new CoachRepository();
		List<Coach> coaches = coachRepository.findAll();
		for (Coach coach : coaches) {
			outputView.printMessage(coach.getName() + OperationMessage.INPUT_AVOID_FOODS.getMessage());
			List<String> avoidFoods = inputView.inputAvoidFoods();
			coach.setAvoidMenus(avoidFoods);
		}
	}

	private void viewMenuRecommendationResult() {
		MenuManager menuManager = new MenuManager();
		outputView.printMessage(OperationMessage.RECOMMEND_RESULT.getMessage());
		outputView.printListWithJoining(createLunchDaysForView());
		outputView.printListWithJoining(createCategoriesForView(menuManager.getRecommendedCategories()));
		menuManager.recommendMenus();
		createRecommendedMenusForView();
		outputView.printBlankLine();
		outputView.printMessage(OperationMessage.RECOMMEND_SUCCESS.getMessage());
	}

	private List<String> createCategoriesForView(Map<DayOfWeek, MenuCategory> recommendedCategories) {
		final String CATEGORY_PREFIX = "카테고리";

		List<String> categoryNames = new ArrayList<>();
		categoryNames.add(CATEGORY_PREFIX);
		for (DayOfWeek day : DayOfWeek.values()) {
			categoryNames.add(recommendedCategories.get(day).getName());
		}
		return categoryNames;
	}

	private List<String> createLunchDaysForView() {
		List<String> days = new ArrayList<>();
		days.add("구분");
		for (DayOfWeek day : DayOfWeek.values()) {
			days.add(day.getName());
		}
		return days;
	}

	private void createRecommendedMenusForView() {
		CoachRepository coachRepository = new CoachRepository();
		List<Coach> coaches = coachRepository.findAll();
		for (Coach coach : coaches) {
			List<String> recommendedMenus = new ArrayList<>();
			recommendedMenus.add(coach.getName());
			for (DayOfWeek day : DayOfWeek.values()) {
				recommendedMenus.add(coach.getRecommendedMenus().get(day));
			}
			outputView.printListWithJoining(recommendedMenus);
		}
	}
}
