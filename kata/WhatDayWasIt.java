package kata;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class WhatDayWasIt {

    private static final LocalDate epochDate = LocalDate.parse("1970-01-01");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            int n = Integer.parseInt(input);
            String dayStr = getDayOfWeekAfterNDays(n).toString();
            System.out.println(dayStr.charAt(0) + dayStr.substring(1).toLowerCase());
        }

        sc.close();

    }

    private static DayOfWeek getDayOfWeekAfterNDays(int num) {
        return epochDate.plusDays(num).getDayOfWeek();
    }
}
