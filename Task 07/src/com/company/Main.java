package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива ");
        int[] digits = new int[scanner.nextInt()];
        System.out.println("Введите числа ");
        for (int i = 0; i < digits.length; i++){
            digits[i] = scanner.nextInt();
        }

        for (int i = 0; i < digits.length; i++){
            for (int j = i; j < digits.length; j++){
                if (digits[i] > digits[j]){
                    int temp = digits[i];
                    digits[i] = digits[j];
                    digits[j] = temp;
                }
            }
        }

        for (int i = 0; i < digits.length; i++){
            System.out.println(digits[i]);
        }
    }
}
