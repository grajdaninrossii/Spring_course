package ru.miroslav.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
//    @Autowired
//    @Qualifier("classicalMusic")
    private Music musicRock; // Используем в качестве зависимости
    private Music musicClassic; // Используем в качестве зависимости

    private List<Music> musicList;

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music musicClassic,
                       @Qualifier("musicRock") Music musicRock){
        this.musicRock = musicRock; // внедряем зависимость
        this.musicClassic = musicClassic; // внедряем зависимость
    }

    public MusicPlayer(){}

    public String playMusic(){
        Random max = new Random();
        List musics = new ArrayList() ;
        musics.addAll(musicClassic.getSongs());
        musics.addAll(musicRock.getSongs());

        return "Playing: " + musics.get(max.nextInt(musics.size()));
    }

    public String playMusicList(){
        String musics = "Playing: ";
        musics += "Classic: ";
        for (String music: musicClassic.getSongs()) {
            musics += music + "; ";
        }
        musics += "Rock: ";
        for (String music: musicRock.getSongs()){
            musics += music + "; ";
        }
        return musics;
    }

//    @Autowired
    public void setMusic(Music music){
        this.musicClassic = music;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

//    @Override
//    public String toString() {
//        return "MusicPlayer{" +
//                "music=" + music +
//                ", musicList=" + musicList +
//                ", name='" + name + '\'' +
//                ", volume=" + volume +
//                '}';
//    }
}
