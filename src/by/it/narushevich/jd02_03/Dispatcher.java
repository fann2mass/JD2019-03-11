package by.it.narushevich.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private Dispatcher() {
    }

    static final int K_SPEED = 1000;

    private static final int PLAN = 100;
    private static final AtomicInteger BUYER_COUNTER = new AtomicInteger(0);
    private static final AtomicInteger BUYER_IN_MARKET = new AtomicInteger(0);

    static double SUM = 0;

    public static int getBuyerCounter() {
        return BUYER_COUNTER.get();
    }
    public static int getBuyerInMarket() {
        return BUYER_IN_MARKET.get();
    }

    static void newBuyer() {
            BUYER_COUNTER.getAndIncrement();
            BUYER_IN_MARKET.getAndIncrement();
    }
    static void deleteBuyer() {
            BUYER_IN_MARKET.getAndDecrement();
    }

    private static final Map<String, Double> listOfGoods = new HashMap<>();

    static {
        listOfGoods.put("Bread", 0.75);
        listOfGoods.put("Bun", 0.45);
        listOfGoods.put("Milk", 1.55);
        listOfGoods.put("Kefir", 1.60);
        listOfGoods.put("Sour cream", 1.95);
        listOfGoods.put("Fish", 12.95);
        listOfGoods.put("Meat", 13.95);
        listOfGoods.put("Dumplings", 3.35);
        listOfGoods.put("Cheese", 9.45);
        listOfGoods.put("Apples", 1.95);
        listOfGoods.put("Oranges", 1.85);
        listOfGoods.put("Banana", 3.25);
        listOfGoods.put("Sausages", 8.35);
        listOfGoods.put("Eggs", 3.20);
        listOfGoods.put("Sweets", 10.85);
        listOfGoods.put("Cookies", 5.95);
        listOfGoods.put("Onion", 0.85);
        listOfGoods.put("Parsley", 0.45);
        listOfGoods.put("Bag", 0.20);
        listOfGoods.put("Butter", 2.45);
        listOfGoods.put("Ice-cream", 0.65);
        listOfGoods.put("Cabbage", 0.15);
        listOfGoods.put("Rice", 2.15);
    }

    public static Map<String, Double> getListOfGoods() {
        return listOfGoods;
    }

    static boolean marketOpened() {
        return BUYER_COUNTER.get() <= PLAN && BUYER_IN_MARKET.get() > 0;
    }

    static boolean planInComplete() {
        return BUYER_COUNTER.get() < PLAN;
    }
}

