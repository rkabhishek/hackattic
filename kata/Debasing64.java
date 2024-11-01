package kata;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Debasing64 {

    private static final Map<Character, Integer> base64CharToValueMap = new HashMap<>();

    static {
        String base64Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        for (int i = 0; i < base64Chars.length(); i++) {
            base64CharToValueMap.put(base64Chars.charAt(i), i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            System.out.println(debase64(input));

        }

    }

    private static String debase64(String str) {
        StringBuilder binStr = new StringBuilder();
        for (int i = 0; i < str.length() && str.charAt(i) != '='; i++) {
            // convert to integer
            int value = getIntegerValueFromBase64Char(str.charAt(i));
            // convert integer to binary and merge
            binStr.append(getBinaryStringFromInteger(value));
        }
        return decodeBinary(binStr.toString());
    }

    private static int getIntegerValueFromBase64Char(char ch) {
        return base64CharToValueMap.get(ch);
    }

    private static String getBinaryStringFromInteger(int value) {
        StringBuilder binStr = new StringBuilder(Integer.toBinaryString(value));
        while (binStr.length() < 6) {
            binStr.insert(0, "0");
        }

        return binStr.toString();
    }

    private static String decodeBinary(String binStr) {
        StringBuilder decodedSb = new StringBuilder();
        for (int i = 0; i < binStr.length(); i += 8) {
            if (i + 8 <= binStr.length()) {
                String byteString = binStr.substring(i, i + 8);
                int value = Integer.parseInt(byteString, 2);
                decodedSb.append((char) value);
            }
        }

        return decodedSb.toString();
    }
}
