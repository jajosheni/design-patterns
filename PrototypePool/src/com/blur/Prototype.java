package com.blur;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    private List<String> logList;
    int no = 10;

    public Prototype() {
        logList = new ArrayList<>();
    }

    public Prototype(List<String> list) {
        this.logList = list;
    }

    public void loadData() {

        logList.add("Login");
        logList.add("Logout");
        logList.add("Comment added");
    }


    public List<String> getLogList() {
        return logList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>(this.getLogList());
        return new Prototype(temp);
    }
}

class PrototypePatternTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype log = new Prototype();
        Prototype number = new Prototype();
        number = log;
        log.no = 5;
        System.out.println(number.no);
        System.out.println(log.no);

        //Shallow Copy
        Prototype logNew = log;

        List<String> list = logNew.getLogList();
        list.add("Article Added");
        System.out.println("Shallow Copy");
        System.out.println(log.getLogList());
        System.out.println(logNew.getLogList());

        System.out.println();

        System.out.println(log);
        System.out.println(logNew);
        System.out.println();

        //Deep Copy
        Prototype logNew1 = (Prototype) log.clone();

        List<String> list1 = logNew1.getLogList();
        list1.add("Comment Deleted");

        System.out.println("Deep Copy");
        System.out.println(log.getLogList());
        System.out.println(logNew1.getLogList());

        System.out.println();

        System.out.println(log);
        System.out.println(logNew1);


    }

}