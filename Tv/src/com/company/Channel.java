package com.company;

import java.util.Random;

public class Channel {
    private String name;
    private Program[] programs;
    private int number;
    private int currentCountOfPrograms;
    private final int MAX_COUNT_OF_PROGRAMS = 3;

    public Channel(String name, int number){
        this.name = name;
        this.number = number;
        currentCountOfPrograms = 0;
        programs = new Program[MAX_COUNT_OF_PROGRAMS];
    }

    public void addNewProgram(Program program){
        if (currentCountOfPrograms > MAX_COUNT_OF_PROGRAMS){
            return;
        }
        this.programs[currentCountOfPrograms] = program;
        currentCountOfPrograms++;
    }

    public void showRandomProgram(){
        Random random = new Random();
        int rand = random.nextInt(MAX_COUNT_OF_PROGRAMS);
        if (programs[rand] == null){
            System.out.println("can not find this program");
            return;
        }
        this.programs[rand].whatAboutThisProgram();
    }


}
