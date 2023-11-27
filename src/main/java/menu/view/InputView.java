package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menu.message.ErrorMessage;

public class InputView {
	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public List<String> inputNames() {
		List<String> names = validateInputSeparator(scanner.nextLine());
		return validateInputNamesFormat(validateInputNamesCount(names));
	}

	public List<String> inputAvoidFoods() {
		return List.of(scanner.nextLine().split(","));
	}

	private List<String> validateInputNamesFormat(List<String> inputNames) {
		List<String> names = new ArrayList<>();
		for (String name : inputNames) {
			String trimmedName = name.trim();
			names.add(trimmedName);
		}
		return names;
	}

	private List<String> validateInputNamesCount(List<String> names) {
		final int MIN_COUNT = 2;
		final int MAX_COUNT = 5;

		if (names.size() < MIN_COUNT) {
			throw new IllegalArgumentException(ErrorMessage.MIN_NAME_COUNT_ERROR.getMessage());
		}
		if (names.size() > MAX_COUNT) {
			throw new IllegalArgumentException(ErrorMessage.MAX_NAME_COUNT_ERROR.getMessage());
		}
		return names;
	}

	private List<String> validateInputSeparator(String input) {
		final String SEPARATOR = ",";

		if (!input.contains(SEPARATOR)) {
			throw new IllegalArgumentException(ErrorMessage.NAME_SEPARATOR_ERROR.getMessage());
		}
		return List.of(input.split(SEPARATOR));
	}
}
