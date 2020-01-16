package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String numberAsString = Integer.toString(number);
        char[] charArrayOfNumber = numberAsString.toCharArray();
        int digitSum = 0;
        for (int i = 0; i < charArrayOfNumber.length; i++) {
            digitSum += (int)charArrayOfNumber[i] - '0';
        }

        for (int div = 2; div * div <= digitSum; div++) {
            if (digitSum % div == 0) {
                System.out.println("number is not prime");
                return;
            }
        }
        System.out.println("prime");
    }
}
