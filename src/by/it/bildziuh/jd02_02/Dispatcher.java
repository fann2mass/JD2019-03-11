package by.it.bildziuh.jd02_02;

import java.util.HashMap;

class Dispatcher {

    private static final Object monitorCounters = new Object();

    final static int kSpeed = 100;
    private static final int PLAN = 100;
    private static volatile int buyerCounter = 0;
    static volatile int buyerInMarket = 0;

    static void newBuyer() {
        synchronized (monitorCounters) {
            buyerCounter++;
            buyerInMarket++;
        }
    }

    static void deleteBuyer() {
        synchronized (monitorCounters) {
            buyerInMarket--;
        }
    }

    static boolean marketOpened() {
        return buyerCounter < PLAN || buyerInMarket > 0;
    }

    static boolean planComplete() {
        return buyerCounter == PLAN;
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

}
