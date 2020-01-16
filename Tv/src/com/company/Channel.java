package com.company;

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


}
