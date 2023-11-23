package menu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import menu.MenuCategory;

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
