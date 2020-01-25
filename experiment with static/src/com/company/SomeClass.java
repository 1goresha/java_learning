package com.company;

public class SomeClass {
    public static String someMessage;

    public void setSomeMessage(String someMessage) {
        SomeClass.someMessage = someMessage;
    }

    public static void setStaticSomeMessage(String someMessage) {
        SomeClass.someMessage = someMessage;
    }
}
