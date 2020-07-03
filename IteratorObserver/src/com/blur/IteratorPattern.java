package com.blur;

interface Iterator {
    public boolean hasNext();
    public Object next();
}
interface Container {
    public Iterator getIterator();
}

class ArticleCategories implements Container {
    public String[] articles = {"Politics" , "Literature" ,"Science" , "Travelling"};

    @Override
    public Iterator getIterator() {
        return new ArticleIterator();
    }

    private class ArticleIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            return index < articles.length;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return articles[index++];
            }
            return null;
        }
    }
}



public class IteratorPattern {

    public static void main(String[] args) {
        ArticleCategories articleCategories = new ArticleCategories();

        for(Iterator iter = articleCategories.getIterator(); iter.hasNext();){
            String entry = (String)iter.next();
            System.out.println("Article : " + entry);
        }
    }
}