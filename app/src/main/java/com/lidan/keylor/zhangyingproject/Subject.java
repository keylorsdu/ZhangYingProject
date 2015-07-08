package com.lidan.keylor.zhangyingproject;

import java.util.ArrayList;

/**
 * Created by keylor on 15-7-8.
 */
public abstract class Subject {
    ArrayList<Observer> observers = new ArrayList<>();

    //添加监听器
    public void attach(Observer observer) {
        if(observer!=null) {
            observers.add(observer);
        }
    }
    //移除监听器
    public void detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        } else {
            System.out.println("observer not find");
        }

    }
    //清除所有监听器
    public void detachAll() {
        observers.clear();
    }
    //通知所有监听器更新
    public void notify(int progress) {
        for (Observer observer : observers) {
            observer.update(progress);
        }
    }

}
