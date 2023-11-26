package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
	private final String name;
	private List<String> avoidFoods;

	public Coach(String name) {
		this.name = name;
		this.avoidFoods = new ArrayList<>();
	}

	public boolean isAvoidFood(String menu) {
		return avoidFoods.stream().anyMatch(menu::equals);
	}

	public String getName() {
		return name;
	}

	// TODO: setter 삭제
	public void setAvoidFoods(List<String> avoidFoods) {
		this.avoidFoods = avoidFoods;
	}

	// TODO: 이름 글자수 2-4 유효성 검사
}
