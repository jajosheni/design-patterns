
package com.blur;

public class ArticleFactory {
    public static ArticleCategory createEntry(Class aClass) throws IllegalAccessException, InstantiationException {
        return (ArticleCategory) aClass.newInstance();
    }

}
