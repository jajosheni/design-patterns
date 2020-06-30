
package com.blur;

public interface ArticleCategory {
    void showArticles();

}

class Politics implements ArticleCategory {

    @Override
    public void showArticles() {
        System.out.println("Politics articles");
    }
}

class Sport implements ArticleCategory {

    @Override
    public void showArticles() {
        System.out.println("Sport articles");
    }

}

class Travel implements ArticleCategory {

    @Override
    public void showArticles() {
        System.out.println("Travel Articles");
    }

}

class Science implements ArticleCategory {

    @Override
    public void showArticles() {
        System.out.println("Science articles");
    }

}

class Literature implements ArticleCategory {
    @Override
    public void showArticles() {
        System.out.println("Literature articles");
    }
}

class Main {

    public static void main(String[] args) {

        try {
            Politics politics = (Politics) ArticleFactory.createEntry(Politics.class);
            politics.showArticles();


            Science science = (Science) ArticleFactory.createEntry(Science.class);
            science.showArticles();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}