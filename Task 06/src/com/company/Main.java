package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int[] digits = new int[7];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = scanner.nextInt();
        }

        for (int i = 0; i < digits.length / 2; i++) {
            int temp = digits[i];
            digits[i] = digits[digits.length - i - 1];
            digits[digits.length - i - 1] = temp;
        }

        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }
    }
}
