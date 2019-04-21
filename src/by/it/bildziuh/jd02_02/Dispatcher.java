package by.it.bildziuh.jd02_02;

class Dispatcher {

    private static final Object monitorCounters = new Object();

    final static int kSpeed = 1000;
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

}
