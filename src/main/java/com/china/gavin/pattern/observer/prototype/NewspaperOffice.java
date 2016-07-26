package com.china.gavin.pattern.observer.prototype;

import java.util.ArrayList;
import java.util.List;

public class NewspaperOffice implements ISubject {

    List<IObserver> lstObservers = null;

    public NewspaperOffice() {
        lstObservers = new ArrayList<IObserver>();
    }

    @Override
    public void registerObserver(IObserver pObserver) {
        if (pObserver == null) {
            throw new NullPointerException();
        }
        lstObservers.add(pObserver);
    }

    @Override
    public void removeObserver(IObserver pObserver) {
        if (lstObservers.contains(pObserver))
            lstObservers.remove(pObserver);
    }

    @Override
    public void notifyObservers(String msg) {
        for (IObserver observer : lstObservers) {
            observer.update(msg);
        }
    }

    public void subscribeNewspaper(IObserver pObserver) {
        this.registerObserver(pObserver);
    }

    public void unsubscribeNewspaper(IObserver pObserver) {
        this.removeObserver(pObserver);
    }

    public void sendNewpaper(String msg) {
        this.notifyObservers(msg);
    }
}
