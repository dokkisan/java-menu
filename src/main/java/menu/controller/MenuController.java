package menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menu.Coach;
import menu.OperationMessage;
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
		System.out.println("coaches = " + coaches);
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
}
