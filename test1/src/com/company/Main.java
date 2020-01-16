package com.company;

public class Main {

    public static int recursion(int n){
        if(n == 1 || n == 0){
            return  n;
        }
        return recursion(n-1) * n;
    }

    public static String naturalNumbers(int n){
        if(n == 1){
            return n + " ";
        }
        return naturalNumbers(n-1) + n + " ";
    }

    public static String numbersFromAtoB(int a, int b){
        String result = "";
        if (a < b){
            result = a + " " + numbersFromAtoB(a + 1,b);
        }else if (a > b){
            result =  a + " " + numbersFromAtoB(a - 1, b);
        }else{
            result = a + " ";
        }
        return result;
    }

    public static void main(String[] args) {
	// write your code here
//        System.out.println(recursion(3));
//        System.out.println(naturalNumbers(10));
        System.out.println(numbersFromAtoB(5,0));
    }
}
