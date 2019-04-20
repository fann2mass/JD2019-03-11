package by.it.narushevich.jd02_03;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private Dispatcher() {
    }

    final static int kSpeed = 1000;

    private final static int plan = 100;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);

    public static int getBuyerCounter() {
        return buyerCounter.get();
    }

    public static int getBuyerInMarket() {
        return buyerInMarket.get();
    }

    static void newBuyer() {
            buyerCounter.getAndIncrement();
            buyerInMarket.getAndIncrement();
    }

    static void deleteBuyer() {
            buyerInMarket.getAndDecrement();
    }

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

    static boolean marketOpened() {
        return buyerCounter.get() < plan || buyerInMarket.get() > 0;
    }

    static boolean planComplete() {
        return buyerCounter.get() == plan;
    }
}

