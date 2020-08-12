package ru.igoresha.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static ru.igoresha.spring.MusicGenre.ROCK;

public class SpringTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Music music = classPathXmlApplicationContext.getBean("music", Music.class);

//        MusicPlayer musicPlayer = new MusicPlayer(music);

//        MusicPlayer musicPlayer = classPathXmlApplicationContext.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playSong();

        MusicPlayer musicPlayer = classPathXmlApplicationContext.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playSong(ROCK);

        classPathXmlApplicationContext.close();
    }
}
