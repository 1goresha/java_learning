package com.company;

public class Program {
    private String name;
    private String whatAboutIt;

    public Program(String name, String whatAboutIt){
        this.name = name;
        this.whatAboutIt = whatAboutIt;
    }

    public void whatAboutThisProgram(){
        System.out.println(whatAboutIt);
    }


}
