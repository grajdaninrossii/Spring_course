package ru.miroslav.music;

import java.util.ArrayList;
import java.util.Arrays;

public class MusicPop implements Music {


    @Override
    public String getSong() {
        return "МАЛИНОВАЯ ЛАДА";
    }

    public ArrayList<String> getSongs(){
        return new ArrayList<String>(Arrays.asList("МАЛИНОВАЯ ЛАДА", "Все у нас прекрасно", "Barbie Girl"));
    }
}
