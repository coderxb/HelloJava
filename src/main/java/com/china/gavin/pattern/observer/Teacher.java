package com.china.gavin.pattern.observer;

import java.util.Observable;

public class Teacher extends Observable {

    public void setChanged(boolean isChange) {
        if (isChange) {
            super.setChanged();
        }
        notifyObservers("Teacher is no behavior.");
    }
}
