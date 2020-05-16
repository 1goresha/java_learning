package com.company;

class A {
    public static String s3;
    public String s4;
}


public class Main {

    public static String s1;
    //public String s3;

    public static void main(String[] args) {
        // write your code here
        String s2;
//        if (s1.equals(s2)) {
//            System.out.println("Hello world");
//        } else {
//            throw new NullPointerException();
//        }



        A a = new A();
//
//        if (a.s4.length() >= 0){
//            System.out.println(s1.length());
//            System.out.println("Hello world");
//        }else{
//            System.out.println("");
//        }

//        String s = "Hello world";
//        char[] c = s.toCharArray();
//        System.out.println(c[99]);

//      if(a.s4 == null){
//          throw new NullPointerException();
//      }

      try{
          a.s4.length();
      }catch (NullPointerException e){
          throw new ArithmeticException();
      }
    }

}
