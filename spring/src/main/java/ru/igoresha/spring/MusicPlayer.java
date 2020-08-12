package ru.igoresha.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static ru.igoresha.spring.MusicGenre.CLASSICAL;
import static ru.igoresha.spring.MusicGenre.ROCK;

@Component
public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();
    private RockMusic rockMusic;
    private ClassicalMusic classicalMusic;


    private String name;
    private int volume;

    public MusicPlayer() {

    }

    @Autowired
    public MusicPlayer(RockMusic rockMusic, ClassicalMusic classicalMusic) {
        this.rockMusic = rockMusic;
        this.classicalMusic = classicalMusic;
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

//    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
//        this.classicalMusic = classicalMusic;
//        this.rockMusic = rockMusic;
//    }

//    public List<Music> getMusicList() {
//        return musicList;
//    }
//
//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }

    public void playSongs() {
        for (Music m :
                musicList) {
            System.out.println("играет музыка : " + m.getSong());
        }

    }

    public void playSong(Enum musicGenre) {
//        System.out.println(rockMusic.getSong());
//        System.out.println(classicalMusic.getSong());

        if (musicGenre.equals(ROCK)){
            System.out.println(rockMusic.getSong());
        }else if (musicGenre.equals(CLASSICAL)){
            System.out.println(classicalMusic.getSong());
        }else{
            System.out.println("null");
        }
    }
}
