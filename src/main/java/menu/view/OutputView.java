package menu.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printBlankLine() {
		System.out.println();
	}

	public void printListWithJoining(List<String> result) {
		System.out.println(result.stream()
			.map(String::valueOf)
			.collect(Collectors.joining(" | ", "[ ", " ]")));
	}
}
