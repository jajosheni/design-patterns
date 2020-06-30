package com.blur;

abstract class Article {
    public String type() {
        return "Article";
    }
}
class Politics extends Article {
    @Override
    public String type() {
        return "Politics";
    }
}
class Science extends Article {
    @Override
    public String type() {
        return "Science";
    }
}
class Travelling extends Article {
    @Override
    public String type() {
        return "Travelling";
    }
}

class Test {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Article entry = ArticleSource.getEntry(Politics.class);
        System.out.println(entry.type() + " " + entry.toString());
        Article entry2 = ArticleSource.getEntry(Travelling.class);
        System.out.println(entry2.type() + " " + entry2.toString());
        Article entry3 = ArticleSource.getEntry(Science.class);
        System.out.println(entry3.type() + " " + entry3.toString());

    }
}