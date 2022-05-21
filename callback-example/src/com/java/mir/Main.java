package com.java.mir;

public class Main {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass(); // Создаем объект класса с колбеком
        MyClass myClass = new MyClass(); // Класс колбека

        // Инициализируем колбек, передавая методу registerCallBack экземпляр MyClass, реализующий интерфейс колбек
        someClass.registerCallBack(myClass);
        someClass.doSomething();

    }
}
