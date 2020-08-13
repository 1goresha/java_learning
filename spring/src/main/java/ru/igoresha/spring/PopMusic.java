package ru.igoresha.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

public class PopMusic implements Music{

    private String[] songs = {"Ну где же вы девченки", "лучшие друзья девушек - это брилланты", "ешь мясо, пей пиво"};

    @Override
    public String getSong() {
        Random r = new Random();
        int randomSongNumber = r.nextInt(songs.length);
        return songs[randomSongNumber];
    }
}
