package by.it.eslaikouskaya.jd02_03;

import java.util.HashMap;

class Dispatcher {

    private Dispatcher() {
    }


    private static final Object monitorCounters = new Object();

    final static int kSpeed=100;

    private static final int PLAN = 100;
    private static volatile int buyerCounter = 0;
    private static volatile int buyerInMarket = 0;


    private static HashMap<String,Double> products = new HashMap<String,Double>() {
        {
            put("potato", 2.0);
            put("milk", 4.5);
            put("bread", 1.5);
            put("eggs", 3.0);
            put("bubble gum", 1.0);
            put("rice", 2.0);
            put("peanuts", 4.0);
            put("water", 0.5);
            put("tea", 5.0);
            put("cheese", 3.0);
            put("ice-cream", 6.0);
            put("carrot", 1.0);
            put("fish", 4.0);
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

    static int getBuyerCounter(){return buyerCounter;}
}
