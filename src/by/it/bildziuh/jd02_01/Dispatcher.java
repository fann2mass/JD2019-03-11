package by.it.bildziuh.jd02_01;

import java.util.HashMap;

class Dispatcher {

    final static int kSpeed = 1000;
    final static int finishTime = 120;

    final static HashMap<String, Double> listOfGoods = new HashMap<String, Double>() {
        {
            put("Soda", 3.99);
            put("Beer", 7.99);
            put("Cereal", 3.49);
            put("Frozen dinners", 9.99);
            put("Snacks", 2.99);
            put("Milk", 4.49);
            put("Bread", 2.99);
            put("Meat", 14.49);
            put("Pasta", 6.49);
        }
    };

}
