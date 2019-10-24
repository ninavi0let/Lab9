package co.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String userInput;

		boolean isValid = true;

		// create HashMap for String and Double parameters
		Map<String, Double> map = new HashMap<>();
		// add String array list for items
		List<String> items = new ArrayList<>();
		List<Double> cost = new ArrayList<>();

		map.put("mittens", 12.00);
		map.put("hot chocolate", 6.99);
		map.put("fuzzy blanket", 25.00);
		map.put("snow globe", 10.99);
		map.put("ear muffs", 7.50);
		map.put("snow pants", 44.00);
		map.put("goggles", 23.99);
		map.put("peppermint candle", 14.99);

		do {

			System.out.println(" Welcome to Nina's Market!\n");
			System.out.printf("  Item              Price\n");
			System.out.println("==========================\n\n");

			// print the menu
			printMenu(map);

			userInput = Validator.getString(scan, "\nWhat item would you like?");

			if (map.keySet().contains(userInput.toLowerCase())) {
				// add key(or NAME of item to list)
				items.add(userInput);
				// add the value(or PRICE to list)
				cost.add(map.get(userInput));

				System.out.println("Adding " + userInput + " to cart at $" + map.get(userInput));

				userInput = Validator.getString(scan, "Would you like to order anything else(y/n)?");
				if (userInput.charAt(0) != 'y') {
					isValid = false;
				}

			} else {
				System.out.println("Sorry, we don't have those.");
			}

		} while (isValid);

		System.out.println("Thanks for your order!\nHere's what you got:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i) + " $" + cost.get(i));
		}

		scan.close();
	}

	private static void printMenu(Map<String, Double> map) {
		for (String itemName : map.keySet()) {
			System.out.printf("%-19s %-12.2f", itemName, map.get(itemName));
			System.out.println();
		}

	}

}