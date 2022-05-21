package ru.miroslav.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.miroslav.music")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    // Ручная инициализвация бинов
//    @Bean
//    public MusicClassic classicalMusic(){
//        return new MusicClassic();
//    }
//
//    @Bean
//    public MusicRock musicRock(){
//        return new MusicRock();
//    }
//
//    @Bean
//    public MusicPlayer musicPlayer(){
//        return  new MusicPlayer(musicRock(), classicalMusic());
//    }

}
