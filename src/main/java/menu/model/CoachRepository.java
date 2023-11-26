package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachRepository {
	private static int id;
	private static Map<Integer, Coach> coaches = new HashMap<>();

	public void save(Coach coach) {
		coaches.put(++id, coach);
	}

	public List<Coach> findAll() {
		return new ArrayList<>(coaches.values());
	}
}
