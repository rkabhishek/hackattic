package kata;

import java.util.Scanner;

class AlmostBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            System.out.println(convertToDecimal(input));
        }
    }

    private static int convertToDecimal(String hashDotBinaryString) {
        double decimal = 0.0;
        int len = hashDotBinaryString.length();

        for (int i = 0; i < len; i++) {
            char currentChar = hashDotBinaryString.charAt(i);
            decimal = decimal + (currentChar == '#' ? Math.pow(2, len - 1 - i) : 0);
        }
        return (int)decimal;
    }
}