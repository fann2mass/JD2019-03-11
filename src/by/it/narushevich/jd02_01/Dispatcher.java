package by.it.narushevich.jd02_01;

import java.util.HashMap;

class Dispatcher {
    final static int kSpeed=1000;
    final static int finishTime=120;

    static HashMap<String, Integer> listOfGoods = new HashMap<String, Integer>() {{
        put("Bread", 1);
        put("Bun", 1);
        put("Milk", 1);
        put("Kefir", 1);
        put("Sour cream", 2);
        put("Fish", 12);
        put("Meat", 13);
        put("Dumplings", 3);
        put("Cheese", 9);
        put("Apples", 2);
        put("Oranges", 2);
        put("Banana", 3);
        put("Sausages", 8);
        put("Eggs", 3);
        put("Sweets", 10);
        put("Cookies", 6);
        put("Onion", 1);
        put("Parsley", 1);
        put("Bag", 1);
        put("Butter", 2);
        put("Ice-cream", 2);
    }};

    public static HashMap<String, Integer> getListOfGoods() {
        return listOfGoods;
    }
}
