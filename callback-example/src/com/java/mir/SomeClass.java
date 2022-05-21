package com.java.mir;

import javax.swing.*;

public class SomeClass {

    String replyTo;

    interface Callback{
        void callingBack(String s);
    }

    private Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    void doSomething(){

        // Создаем диалоговое окно
        int reply = JOptionPane.showConfirmDialog(null, "Вы программист?", "Опрос", JOptionPane.YES_NO_OPTION);

        // Смотрим ответ и...
        if (reply == JOptionPane.NO_OPTION){
            replyTo = "Нет";
        }
        if (reply == JOptionPane.YES_OPTION){
            replyTo = "Да";
        }

        // ... вызваем колбек с аргументом(=ответу в диалоге)
        callback.callingBack(replyTo);
    }

}
