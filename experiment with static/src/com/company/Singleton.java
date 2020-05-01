package com.company;

public class Singleton {
    private String message;

    private static final Singleton instance;

    private Singleton(){

    }

    static{
        instance = new Singleton();
    }

    public static Singleton getSingletonObjectVariable(){
        return instance;
    }

    public void setLog(String message){
        this.message = message;
    }

    public String getLog(){
        return this.message;
    }
}
