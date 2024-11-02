package kata;

import java.util.Scanner;
import java.util.Stack;

public class OpenParens {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			if (input.isEmpty()) {
				break;
			}
			System.out.println(isClosed(input));
		}
	}

	private static String isClosed(String str) {
		Stack<Character> paren = new Stack<>();
		for (char c: str.toCharArray()) {
			if (c == '(') {
				paren.push(c);
			} else { // when c == ')'
				if (!paren.isEmpty() && paren.peek() == '(') {
					paren.pop();
				} else {
					return "no";
				}
			}
		}

		if (paren.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}
