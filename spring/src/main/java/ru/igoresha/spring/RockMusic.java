package ru.igoresha.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

import static ru.igoresha.spring.MusicGenre.CLASSICAL;
import static ru.igoresha.spring.MusicGenre.ROCK;

//@Component
public class RockMusic implements Music {

    private String[] songs = {"Knock the heaven door", "we will rock you", "final countdown"};

    @Override
    public String getSong() {
        Random r = new Random();
        int randomSongNumber = r.nextInt(songs.length);
        return songs[randomSongNumber];
    }
}
