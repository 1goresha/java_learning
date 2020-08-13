package ru.igoresha.spring;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static ru.igoresha.spring.MusicGenre.CLASSICAL;
import static ru.igoresha.spring.MusicGenre.ROCK;

//@Component
public class ClassicalMusic implements Music{


//    public static ClassicalMusic getClassicalMusic() {
//        return new ClassicalMusic();
//    }
//
//    public void initMethod(){
//        System.out.println("init method is working");
//    }
//
//    public void destroyMethod(){
//        System.out.println("destroy method is working");
//    }

    private String[] songs = {"Богемская рапсодия", "лунная соната", "Мессия"};

    @Override
    public String getSong() {
        Random r = new Random();
        int randomSongNumber = r.nextInt(songs.length);
        return songs[randomSongNumber];
    }
}
