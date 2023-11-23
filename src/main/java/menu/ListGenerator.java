package menu;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator {

    public List<DayOfWeek> generateDays() {
        return new ArrayList<>(List.of(DayOfWeek.values()));
    }

    public List<LunchCategory> generateCategories() {
        return new ArrayList<>(List.of(LunchCategory.values()));
    }
}
