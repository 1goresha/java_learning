package ru.igoresha.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
//@ComponentScan("ru.igoresha.spring")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }

    @Bean
    public PopMusic popMusic(){
        return new PopMusic();
    }

    @Bean
    public List<Music> musicList(){
        return Arrays.asList(rockMusic(), classicalMusic(), popMusic());
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(musicList());
    }
}
