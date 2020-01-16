package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String result = "";
        if (number >= 0 && number <= 255){
            int tempNumber = 0;
            for (int i =0; number != 1; i++){
                tempNumber = number % 2;
                result += Integer.toString(tempNumber);
                number /=2;
            }
            result+="1";
            char[] charResult = result.toCharArray();
            for (int i =0; i <charResult.length/2; i++){
                char tempChar = charResult[i];
                charResult[i] = charResult[charResult.length-i-1];
                charResult[charResult.length-i-1] = tempChar;
            }
            String newStringResult = new String(charResult);
            System.out.println(newStringResult);
        }else{
            System.out.println("number is out of rage");
        }
    }
}
