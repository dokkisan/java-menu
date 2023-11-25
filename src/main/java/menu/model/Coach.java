package menu.model;

import java.util.List;

public class Coach {
	private String name;
	private List<String> avoidFoods;

	public Coach(String name, List<String> avoidFoods) {
		this.name = name;
		this.avoidFoods = avoidFoods;
	}

	public boolean isAvoidFood(String menu) {
		return avoidFoods.stream().anyMatch(menu::equals);
	}

	public String getName() {
		return name;
	}
}
