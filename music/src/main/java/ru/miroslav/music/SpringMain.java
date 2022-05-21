package ru.miroslav.music;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicClassic classicalMusic = context.getBean("musicBean", MusicClassic.class);

        System.out.println(classicalMusic.getSong());

//        Music music = context.getBean("musicBean", Music.class);
//
//        // Внедряем зависимость в ручную с помощью подхода Inversion of Control (IoC)
//        MusicPlayer musicPlayer = new MusicPlayer(music);

//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        firstMusicPlayer.playMusic();
//        firstMusicPlayer.playMusicList();
//
//        // Меняем scope с singltone на prototype для
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        boolean compression = firstMusicPlayer == secondMusicPlayer;
//        System.out.println(compression);
//        System.out.println(firstMusicPlayer + "\n" + secondMusicPlayer);
//        firstMusicPlayer.setVolume(24);
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());

//        // name and volume with property in xml
//        System.out.println(firstMusicPlayer.getName());
//        System.out.println(firstMusicPlayer.getVolume());

        System.out.println(MusicClassic.class);

        context.close();
//        System.out.println();
    }

}
