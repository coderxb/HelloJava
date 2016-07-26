package com.china.gavin.pattern.observer.prototype;

public class Client {
    public static void main(String[] args) {
        NewspaperOffice office = new NewspaperOffice();

        Customer arvin = new Customer("Arvin");
        office.subscribeNewspaper(arvin);

        Customer jack = new Customer("Jack");
        office.subscribeNewspaper(jack);

        office.sendNewpaper("News One ...");
        office.removeObserver(arvin);

        office.sendNewpaper("News Two ...");
    }
}
