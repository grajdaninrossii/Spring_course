package ru.miroslav.music;

public class MusicClassic implements Music {

    private MusicClassic(){} // делаем приватный конструктор

    // Фабричный метод
    public static MusicClassic getMusicClassic(){
        System.out.println("factory-method");
        return new MusicClassic();
    }

    // Конструктор для Spring
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }

    // Деструктор для Spring
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong(){
        return "Hungarian Rhapsody";
    }
}
