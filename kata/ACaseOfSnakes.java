package kata;

import java.util.Arrays;
import java.util.Scanner;

public class ACaseOfSnakes {

    private static final String[] prefixes = {"u32", "fn", "dw", "u64", "p", "d", "f", "w", "b", "ch", "i32", "i16", "i64"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.isEmpty()) {
                break;
            }
            System.out.println(convertHungarianToSnake(str));
        }

    }

    private static String convertHungarianToSnake(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder prefixSb = new StringBuilder();
        int index = 0;

        while (index < str.length() && !Character.isUpperCase(str.charAt(index))) {
            prefixSb.append(str.charAt(index));
            index++;
        }

        if (!Arrays.asList(prefixes).contains(prefixSb.toString())) {
            sb.append(prefixSb);
        }

        for (int i = index; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
                if (sb.length() != 0) {
                    sb.append('_');
                }
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}
