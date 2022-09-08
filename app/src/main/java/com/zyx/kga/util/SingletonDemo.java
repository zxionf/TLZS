package com.zyx.kga.util;

public class SingletonDemo {
    private static SingletonDemo instance;
    private SingletonDemo(){
        Music.start("/storage/emulated/0/0000/music/are_you_lost.mp3");
    }
    public static SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
