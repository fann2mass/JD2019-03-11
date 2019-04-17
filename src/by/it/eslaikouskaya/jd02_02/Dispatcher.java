package by.it.eslaikouskaya.jd02_02;

import java.util.HashMap;

class Dispatcher {

    private Dispatcher() {
    }


    private static final Object monitorCounters = new Object();

    final static int kSpeed=100;

    private static final int PLAN = 100;
    private static volatile int buyerCounter = 0;
    private static volatile int buyerInMarket = 0;


    private static HashMap<String,Double> products = new HashMap<>() {
        {
            put("potato", 2.0);
            put("milk", 4.1);
            put("bread", 1.5);
            put("eggs", 3.2);
            put("bubble gum", 1.2);
            put("rice", 1.7);
            put("peanuts", 4.3);
            put("water", 0.5);
        }
    };

    static HashMap<String, Double> getGoods() {
        return products;
    }

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
}
