package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число : ");
        char[] chars;
        chars = scanner.nextLine().toCharArray();
        int a = 0;

        for (int i = 0; i < chars.length; i++) {
//            a += ((int)chars[i] - '0')*10;
            a *= 10;
            a += (int) chars[i] - '0';
        }
        System.out.println(a);
    }
}
