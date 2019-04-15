package by.it.zalesky.jd01_11;

import java.util.ArrayList;
import java.util.List;


public class Runner {
    public static void main(String[] args) {
        List<String> list = new  ArrayList<>();
        List<String> arlist = new ArrayList<>();
        ///проверяем добавление
        list.add("First"); arlist.add("First");
        list.add("Two"); arlist.add("Two");
        list.add("Four"); arlist.add("Four");
        System.out.println("add list:" +list+"\narlist:" +arlist);
        list.add(2,"Tree"); arlist.add(2,"Tree");
        list.add(0,"Start"); arlist.add(0,"Start");
        System.out.println("add list:" +list+"\narlist:" +arlist);
        ///проверяем удаление
        list.remove("Start"); arlist.remove("Start");
        list.remove(3); arlist.remove(3);
        System.out.println("remove list:" +list+"\narlist:" +arlist);
        ///проверяем чтение
        System.out.println("get list(0):" +list.get(0)+"\narlist:" +arlist);


    }
}

