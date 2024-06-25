package kata;

import java.util.Scanner;

public class AlmostCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            System.out.println(compress(input));
        }
    }

    private static String compress(String str) {
        char activeChar = str.charAt(0);
        int consecutiveCount = 1;
        StringBuilder compressed = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == activeChar) {
                consecutiveCount++;
            } else {
                compressed.append(appendCharacterWithCount(activeChar, consecutiveCount));
                activeChar = currentChar;
                consecutiveCount = 1;
            }
        }

        compressed.append(appendCharacterWithCount(activeChar, consecutiveCount));
        return compressed.toString();
    }

    private static String appendCharacterWithCount(char c, int count) {
        StringBuilder result = new StringBuilder();
        if (count > 2) {
            result.append(count).append(c);
        } else {
            result.append(String.valueOf(c).repeat(count));
        }
        return result.toString();
    }
}
