package ru.miroslav.music;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class MusicRock implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }

    public ArrayList<String> getSongs(){
        return new ArrayList<String>(Arrays.asList("I am Machine", "Stayin' in Black", "Hell or Hallelujah"));
    }
}
