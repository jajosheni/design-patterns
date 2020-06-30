package com.blur;

import java.util.HashMap;
import java.util.Map;

public class ArticleSource {
    private static  ArticleSource source = new  ArticleSource();
    private static Map<Class<? extends Article> ,Article> poolMap = new HashMap<>();
    static int size = poolMap.size();

    private ArticleSource () {
    }

    public static Article getEntry(Class<? extends Article> mClass) throws IllegalAccessException, InstantiationException {

        Article b = source.poolMap.get(mClass);

        if (b == null) {
            b = mClass.newInstance();
            source.poolMap.put(b.getClass(), b);
            size++;
        }
        return b;
    }
}
