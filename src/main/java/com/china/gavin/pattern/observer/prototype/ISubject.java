package com.china.gavin.pattern.observer.prototype;

public interface ISubject {

    public void registerObserver(IObserver pObserver);

    public void removeObserver(IObserver pObserver);

    public void notifyObservers(String pContent);

}
