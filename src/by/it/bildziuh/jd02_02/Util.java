package by.it.bildziuh.jd02_02;

import java.util.HashMap;

class Util {

    private Util() {
    }

    final static HashMap<String, Double> listOfGoods = new HashMap<String, Double>() {
        {
            put("Soda", 3.99);
            put("Beer", 7.99);
            put("Cereal", 3.49);
            put("Dinner", 9.99);
            put("Snacks", 2.99);
            put("Milk", 4.49);
            put("Bread", 2.99);
            put("Meat", 14.49);
            put("Pasta", 6.49);
        }
    };

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Dispatcher.kSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int start, int stop) {
        return (int) (Math.random() * (stop - start + 1)) + start;
    }

    static int random(int range) {
        return random(0, range);
    }

}
