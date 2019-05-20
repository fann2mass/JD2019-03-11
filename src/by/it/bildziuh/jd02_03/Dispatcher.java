package by.it.bildziuh.jd02_03;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private Dispatcher() {
    }

    final static int kSpeed = 1000;
    private static final int PLAN = 100;

    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    static final AtomicInteger buyerInMarket = new AtomicInteger(0);
//    static final AtomicInteger buyerInQueue = new AtomicInteger(0);

    static final AtomicInteger cashierActive = new AtomicInteger(0);
    static final int cashierMax = 5;
    //параметры вывода чека на печать
    static final int checkWidth = 18;
    static final int checkTab = 4;

    static double income = 0;

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

    static void newBuyer() {
        buyerCounter.getAndIncrement();
        buyerInMarket.getAndIncrement();
    }

    static void deleteBuyer() {
        buyerInMarket.getAndDecrement();
    }

    static boolean marketOpened() {
        return buyerCounter.get() < PLAN || buyerInMarket.get() > 0;
    }

    static boolean planComplete() {
        return buyerCounter.get() == PLAN;
    }

    public static int getBuyerCounter() {
        return buyerCounter.get();
    }
    public static int getBuyerInMarket() {
        return buyerInMarket.get();
    }


}
