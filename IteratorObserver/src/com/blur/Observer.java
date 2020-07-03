package com.blur;

import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void notify(String message);
}

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

class NoticeObservable implements Observable {

    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.notify("Warning!");
        }
    }

}

class Comment implements Observer {

    private Observable observable;

    @Override
    public void notify(String message) {
        System.out.println(message + "Comment added");
    }

    public void removeObserver(){
        observable.removeObserver(this);
    }

}

class Article implements Observer {

    private Observable observable;

    public Article() {
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void notify(String message) {
        System.out.println(message + "Article Added");
    }

    public void removeObserver(){
        observable.removeObserver(this);
    }

}

class ObserverPattern {

    public static void main(String[] args) {

        Comment comment = new Comment();
        Article article = new Article();

        NoticeObservable noticeObservable = new NoticeObservable();

        article.setObservable(noticeObservable);

        noticeObservable.addObserver(comment);
        noticeObservable.addObserver(article);
        noticeObservable.notifyObserver();

        article.removeObserver();
        noticeObservable.notifyObserver();
    }

}