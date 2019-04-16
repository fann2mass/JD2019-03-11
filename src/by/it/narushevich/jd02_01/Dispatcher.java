package by.it.narushevich.jd02_01;

import java.util.HashMap;

class Dispatcher {
    final static int kSpeed=10000;
    final static int finishTime=120;

    static HashMap<String, Double> listOfGoods = new HashMap<String, Double>() {{
        put("Bread", 0.75);
        put("Bun", 0.45);
        put("Milk", 1.55);
        put("Kefir", 1.60);
        put("Sour cream", 1.95);
        put("Fish", 12.95);
        put("Meat", 13.95);
        put("Dumplings", 3.35);
        put("Cheese", 9.45);
        put("Apples", 1.95);
        put("Oranges", 1.85);
        put("Banana", 3.25);
        put("Sausages", 8.35);
        put("Eggs", 3.20);
        put("Sweets", 10.85);
        put("Cookies", 5.95);
        put("Onion", 0.85);
        put("Parsley", 0.45);
        put("Bag", 0.20);
        put("Butter", 2.45);
        put("Ice-cream", 0.65);
        put("Cabbage", 0.15);
        put("Rice", 2.15);
    }};
}
