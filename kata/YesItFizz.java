package kata;

import java.util.Scanner;

public class YesItFizz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = n; i <= m; i++) {
           System.out.println(fizzBuzz(i));
        }
    }

    private static String fizzBuzz(int num) {
        StringBuilder sb = new StringBuilder();

        if (num % 3 == 0) {
            sb.append("Fizz");
        }
        if (num % 5 == 0) {
            sb.append("Buzz");
        }

       return sb.length() != 0 ? sb.toString() : Integer.toString(num);
    }
}
