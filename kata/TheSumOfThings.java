package kata;

import java.util.Scanner;

public class TheSumOfThings {

	private static final String HEX_PREFIX = "0x";
	private static final String OCTAL_PREFIX = "0o";
	private static final String BINARY_PREFIX = "0b";
	private static final int HEX_BASE = 16;
	private static final int OCTAL_BASE = 8;
	private static final int BINARY_BASE = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			if (input.isEmpty()) {
				break;
			}
			System.out.println(sumOfThings(input));
		}
	}

	private static int sumOfThings(String str) {
		int sum = 0;
		String[] numbers = str.split(" ");

		for (String number: numbers) {
			sum += getDecimal(number);
		}
		return sum;
	}

	private static int getDecimal(String numStr) {
		if (numStr.startsWith(HEX_PREFIX)) {
			return Integer.parseInt(numStr.substring(2), HEX_BASE);
		} else if (numStr.startsWith(OCTAL_PREFIX)) {
			return Integer.parseInt(numStr.substring(2), OCTAL_BASE);
		} else if (numStr.startsWith(BINARY_PREFIX)) {
			return Integer.parseInt(numStr.substring(2), BINARY_BASE);
		} else if (numStr.length() == 1 &&
				((numStr.charAt(0) >= 33 && numStr.charAt(0) <= 47) || (numStr.charAt(0) >= 58 && numStr.charAt(0) <= 127))) {
			return numStr.charAt(0);
		}

		return Integer.parseInt(numStr);
	}
}
