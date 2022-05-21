package ru.miroslav.music;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;

//@Scope("prototype")
@Component("classicalMusic")
@Scope("singleton")
public class MusicClassic implements Music {

    private MusicClassic(){} // делаем приватный конструктор

    // Фабричный метод
    public static MusicClassic getMusicClassic(){
        System.out.println("factory-method");
        return new MusicClassic();
    }

    // Конструктор для Spring
    @PostConstruct
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }

    // Деструктор для Spring
    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong(){
        return "Hungarian Rhapsody";
    }

    public ArrayList<String> getSongs(){
        return new ArrayList<String>(Arrays.asList("Hungarian Rhapsody", "Elegie", "Violin Concerto in D Major"));
    }
}
