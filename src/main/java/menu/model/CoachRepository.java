package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachRepository {
	private static Map<String, Coach> coaches = new HashMap<>();

	public void save(Coach coach) {
		coaches.put(coach.getName(), coach);
	}

	public Coach findByName(String name) {
		return coaches.get(name);
	}

	public List<Coach> findAll() {
		return new ArrayList<>(coaches.values());
	}
}
