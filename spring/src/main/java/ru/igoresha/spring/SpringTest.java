package ru.igoresha.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static ru.igoresha.spring.MusicGenre.CLASSICAL;
import static ru.igoresha.spring.MusicGenre.ROCK;

public class SpringTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

//        Music music = classPathXmlApplicationContext.getBean("music", Music.class);

//        MusicPlayer musicPlayer = new MusicPlayer(music);

//        MusicPlayer musicPlayer = classPathXmlApplicationContext.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playSong();

        MusicPlayer musicPlayer = annotationConfigApplicationContext.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playSong();

        annotationConfigApplicationContext.close();
    }
}
