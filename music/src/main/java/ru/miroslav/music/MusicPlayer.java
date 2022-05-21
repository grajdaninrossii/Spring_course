package ru.miroslav.music;

import java.util.List;

public class MusicPlayer {
    private Music music; // Используем в качестве зависимости
    private List<Music> musicList;

    private String name;
    private int volume;

    public MusicPlayer(Music music){
        this.music = music; // внедряем зависимость
    }

    public MusicPlayer(){}

    public void playMusic(){
        System.out.println("Playing: " + music.getSong());
    }

    public void playMusicList(){
        for (Music music: musicList) {
            System.out.println("Playing: " + music.getSong());
        }
    }

    public void setMusic(Music music){
        this.music = music;
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
