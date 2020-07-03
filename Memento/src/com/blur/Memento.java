package com.blur;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private String content;

    public String getContent() {
        return content;
    }

    public void addContent(final String content) {
        this.content = content;
    }

    public ArticleMemento createMemento() {
        return new ArticleMemento(this);
    }

    public void addContent(final ArticleMemento memento) {
        this.content = memento.getContent();
    }
}

class ArticleMemento {

    private final String content;

    public ArticleMemento(final Memento article) {
        this.content = article.getContent();
    }

    public String getContent() {
        return content;
    }
}

class ArticleCreator {

    private final Memento article;
    private final List<ArticleMemento> articleList = new ArrayList<ArticleMemento>();

    public ArticleCreator(final Memento article) {
        this.article = article;
    }

    public void writeArticle(final String newContent) {
        final ArticleMemento memento = article.createMemento();
        articleList.add(memento);
        article.addContent(newContent);
    }

    public void undo() {
        final ArticleMemento memento = articleList.remove(articleList.size() - 1);
        article.addContent(memento);
    }
}

class Member {

    public static void main(final String[] args) {
        final Memento article = new Memento();
        article.addContent("");

        final ArticleCreator articleCreator = new ArticleCreator(article);
        articleCreator.writeArticle("Politics");
        articleCreator.writeArticle("Literature");
        articleCreator.writeArticle("Science");
        articleCreator.writeArticle("Sport");

        System.out.println("Last content: " + article.getContent());

        articleCreator.undo();
        articleCreator.undo();
        articleCreator.undo();

        System.out.println("after 3 undos : " + article.getContent());
    }
}