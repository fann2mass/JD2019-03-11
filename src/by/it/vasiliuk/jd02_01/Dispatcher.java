package by.it.vasiliuk.jd02_01;

import java.util.HashMap;

class Dispatcher {

    private static final Object monitorCounters = new Object();
    final static int kSpeed = 100;
    final static int fullCycle = 120;
    static volatile int buyerInMarket = 0;

    final static HashMap<String, Double> listOfGoods = new HashMap<String, Double>() {
        {
            put("Onion", 3.99);
            put("Crisps", 7.99);
            put("Garlic", 3.49);
            put("Cheese", 9.99);
            put("Cake", 2.99);
            put("Chicken", 4.49);
            put("Jelly", 2.99);
            put("Water", 14.49);
            put("Soda", 6.49);
        }
    };

    static void newBuyer() {
        synchronized (monitorCounters) {
            buyerInMarket++;
        }
    }

    static void deleteBuyer() {
        synchronized (monitorCounters) {
            buyerInMarket--;
        }
    }

}