package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int moneyINeed = scanner.nextInt();
        int currentMoney = moneyINeed;
        int value5000 = currentMoney/5000;
        currentMoney %= 5000;
        int value2000 = currentMoney/2000;
        currentMoney %= 2000;
        int value1000 = currentMoney/1000;
        currentMoney %=1000;
        int value500 = currentMoney/500;
        currentMoney %=500;
        int value100 = currentMoney/100;
        currentMoney %= 100;
        int value50 = currentMoney/50;
        currentMoney %=50;
        System.out.println("5000р. = " + value5000);
        System.out.println("2000р. = " + value2000);
        System.out.println("1000р. = " + value1000);
        System.out.println("500р. = " + value500);
        System.out.println("100р. = " + value100);
        System.out.println("50р. = " + value50);
    }
}
