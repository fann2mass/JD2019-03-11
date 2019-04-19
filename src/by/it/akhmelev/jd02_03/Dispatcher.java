package by.it.akhmelev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private Dispatcher() {
    }

    static final int K_SPEED = 1000;

    private static final int PLAN = 100;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);

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
}
