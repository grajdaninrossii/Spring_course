package ru.miroslav.music;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

//        Music music = context.getBean("classicalMusic", Music.class);
//        MusicPlayer musicPlayer= context.getBean("musicPlayer", MusicPlayer.class);

//        Computer computer = context.getBean("computer", Computer.class);
//        System.out.println(computer.toString());

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        MusicClassic classicalMusic = context.getBean("classicalMusic", MusicClassic.class);
//        MusicClassic classicalMusic2 = context.getBean("classicalMusic", MusicClassic.class);
//
//        System.out.println(classicalMusic == classicalMusic2);
        context.close();
//        System.out.println();
    }

}
